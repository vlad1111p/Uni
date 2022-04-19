package services;

import dao.GenericDao;
import model.Card;

public class CardService {

    GenericDao<Card> cardGenericDao = new GenericDao<>();

    public void addCard(Card card)
    {
        cardGenericDao.add(card);
    }
}
