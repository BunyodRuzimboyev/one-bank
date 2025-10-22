package uz.br29.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.br29.card.entity.Card;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {

    boolean existsByCardNumber(String cardNumber);

    List<Card> findAllByOwnerId(String ownerId);

    List<Card> findAllByPhoneNumber(String phoneNumber);

}
