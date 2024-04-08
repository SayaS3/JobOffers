package com.junioroffers.domain.offer.exceptions;

import java.util.List;

import com.junioroffers.domain.offer.Offer;
import lombok.Getter;

@Getter
public class OfferSavingException extends RuntimeException {

    private final List<String> offerUrls;

    public OfferSavingException(String offerUrl) {
        super(String.format("Offer with offerUrl [%s] already exists", offerUrl));
        this.offerUrls = List.of(offerUrl);
    }

    public OfferSavingException(String message, List<Offer> offers) {
        super(String.format("error" + message + offers.toString()));
        this.offerUrls = offers.stream().map(Offer::offerUrl).toList();
    }
}
