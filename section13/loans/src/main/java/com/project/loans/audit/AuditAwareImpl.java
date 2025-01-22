package com.project.loans.audit;

import com.project.loans.constants.LoansConstants;
import lombok.NonNull;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(LoansConstants.LOAN_AUDIT_COMPONENT_NAME)
public class AuditAwareImpl implements AuditorAware<String> {

    @NonNull
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(LoansConstants.LOANS_AUDIT);
    }
}
