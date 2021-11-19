package service.cardService;

import library.model.Card;

import java.util.List;

public interface ICardService {
    List<Card> findAllCard();
    void save(Card card);
    Card findById(int id);
    void update(int id);
    void remove(int id);
}
