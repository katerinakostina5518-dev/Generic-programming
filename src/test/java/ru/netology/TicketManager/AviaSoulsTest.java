package ru.netology.TicketManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void testCompareTo() {
        Ticket ticket1 = new Ticket("Москва", "Питер", 1000, 10, 12);
        Ticket ticket2 = new Ticket("Москва", "Питер", 2000, 11, 13);
        Assertions.assertTrue(ticket1.compareTo(ticket2) < 0);
        Assertions.assertTrue(ticket2.compareTo(ticket1) > 0);
        Assertions.assertEquals(0, ticket1.compareTo(ticket1));
    }

    @Test
    public void testSearchSortedByPrice() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Питер", 3000, 10, 12);
        Ticket ticket2 = new Ticket("Москва", "Питер", 2000, 11, 13);
        Ticket ticket3 = new Ticket("Москва", "Питер", 1500, 9, 11);
        Ticket ticket4= new Ticket("Питер", "Москва", 2000, 11, 13);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        Ticket[] expected = {ticket3, ticket2, ticket1};
        Ticket[] actual = manager.search("Москва", "Питер");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testTicketTimeComparator() {
        Ticket ticket1 = new Ticket("Москва", "Питер", 1000, 10, 12);
        Ticket ticket2 = new Ticket("Москва", "Питер", 2000, 11, 14);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Assertions.assertTrue(comparator.compare(ticket1, ticket2) < 0);
        Assertions.assertTrue(comparator.compare(ticket2, ticket1) > 0);
        Assertions.assertEquals(0, comparator.compare(ticket1, ticket1));
    }

    @Test
    public void testSearchAndSortByTime() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Питер", 3000, 10, 13);
        Ticket ticket2 = new Ticket("Москва", "Питер", 2000, 11, 12);
        Ticket ticket3 = new Ticket("Москва", "Питер", 1500, 9, 11);
        Ticket ticket4= new Ticket("Питер", "Москва", 2000, 11, 13);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket2, ticket3, ticket1};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Питер", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
