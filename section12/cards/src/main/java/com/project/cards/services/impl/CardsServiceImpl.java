package com.project.cards.services.impl;

import com.project.cards.constants.CardsConstants;
import com.project.cards.dtos.CardsDTO;
import com.project.cards.entities.Cards;
import com.project.cards.exceptions.CardAlreadyExistsException;
import com.project.cards.exceptions.ResourceNotFoundException;
import com.project.cards.mapper.CardsMapper;
import com.project.cards.repositories.CardsRepository;
import com.project.cards.services.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {

    private CardsRepository cardsRepository;

    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> cards = cardsRepository.findByMobileNumber(mobileNumber);
        if(cards.isPresent()) {
            throw new CardAlreadyExistsException(CardsConstants.CARD_ALREADY_EXISTS_EXCEPTION + mobileNumber);
        }
        cardsRepository.save(createNewCard(mobileNumber));
    }

    private Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }

    @Override
    public CardsDTO fetchCard(String mobileNumber) {
        Cards cards = cardsRepository
                .findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException(CardsConstants.CARD_RESOURCE_NAME,
                        CardsConstants.MOBILE_FIELD_NAME, mobileNumber));
        return CardsMapper.mapToCardsDto(cards, new CardsDTO());
    }

    @Override
    public boolean updateCard(CardsDTO cardsDTO) {
        Cards cards = cardsRepository
                .findByCardNumber(cardsDTO.getCardNumber())
                .orElseThrow(() -> new ResourceNotFoundException(CardsConstants.CARD_RESOURCE_NAME,
                        CardsConstants.CARD_NUMBER_FIELD_NAME, cardsDTO.getCardNumber()));
        CardsMapper.mapToCards(cardsDTO, cards);
        cardsRepository.save(cards);
        return true;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        Cards cards = cardsRepository
                .findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException(CardsConstants.CARD_RESOURCE_NAME,
                        CardsConstants.MOBILE_FIELD_NAME, mobileNumber));
        cardsRepository.deleteById(cards.getCardId());
        return true;
    }
}
