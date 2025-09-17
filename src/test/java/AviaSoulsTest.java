import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AviaSoulsTest {
    AviaSouls aviaSouls = new AviaSouls();

    @Test
    public void shouldCompareToTicketsByPrice () {
        Ticket ticket1 = new Ticket("Москва", "Краснодар", 9000, 12, 16);
        Ticket ticket2 = new Ticket("Москва", "Сочи", 7000, 9, 12);
        Ticket ticket3 = new Ticket("Москва", "Волгоград", 5000, 8, 10);
        Ticket ticket4 = new Ticket("Москва", "Санкт-Петербург", 4000, 10, 11);
        Ticket ticket5 = new Ticket("Москва", "Новосибирск", 10000, 11, 16);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Arrays.sort(aviaSouls.findAll());

        Ticket[] expected = {ticket4, ticket3, ticket2, ticket1, ticket5};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByPriceTickets () {
        Ticket ticket1 = new Ticket("Москва", "Краснодар", 9000, 12, 16);
        Ticket ticket2 = new Ticket("Москва", "Сочи", 7000, 9, 12);
        Ticket ticket3 = new Ticket("Москва", "Волгоград", 5000, 8, 10);
        Ticket ticket4 = new Ticket("Москва", "Сочи", 6500, 10, 11);
        Ticket ticket5 = new Ticket("Москва", "Новосибирск", 10000, 11, 16);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket4, ticket2};
        Ticket[] actual = aviaSouls.search("Москва", "Сочи");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareToTicketsByFlightTime () {
        Ticket ticket1 = new Ticket("Москва", "Краснодар", 9000, 12, 16);
        Ticket ticket2 = new Ticket("Москва", "Сочи", 7000, 9, 12);
        Ticket ticket3 = new Ticket("Москва", "Волгоград", 5000, 8, 10);
        Ticket ticket4 = new Ticket("Москва", "Санкт-Петербург", 4000, 10, 11);
        Ticket ticket5 = new Ticket("Москва", "Новосибирск", 10000, 11, 16);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Arrays.sort(aviaSouls.findAll(), timeComparator);

        Ticket[] expected = {ticket4, ticket3, ticket2, ticket1, ticket5};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByTimeFlightTickets () {
        Ticket ticket1 = new Ticket("Москва", "Краснодар", 9000, 12, 16);
        Ticket ticket2 = new Ticket("Москва", "Сочи", 7000, 9, 12);
        Ticket ticket3 = new Ticket("Москва", "Волгоград", 5000, 8, 10);
        Ticket ticket4 = new Ticket("Москва", "Сочи", 6500, 10, 12);
        Ticket ticket5 = new Ticket("Москва", "Новосибирск", 10000, 11, 16);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket2};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Сочи", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
