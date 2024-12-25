package com.project.cards.services;

import com.project.cards.dtos.CardsDTO;

public interface ICardsService {

    void createCard(String mobileNumber);
    CardsDTO fetchCard(String mobileNumber);
    boolean updateCard(CardsDTO cardsDTO);
    boolean deleteCard(String mobileNumber);
}
