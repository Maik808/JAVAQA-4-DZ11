package ru.netology.domain.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.repozitory.AfishaRepository;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {
    AfishaRepository repository = new AfishaRepository();
    AfishaManager manager = new AfishaManager(repository);
    Film[] expected = {new Film(10, "Serf", "comedy"),
            new Film(9, "Good luck gentlemen", "comedy"),
            new Film(8, "Diamond hand", "comedy"),
            new Film(7, "Howl's moving castle", "fantastic"),
            new Film(6, "Avatar", "fantastic"),
            new Film(5, "Beginning", "fantastic"),
            new Film(4, "Capernaum", "drama"),
            new Film(3, "Green mile", "drama"),
            new Film(2, "Forward", "action"),
            new Film(1, "Call of the ancestors", "action")
    };

    @Test
    void shouldShowTenFilms() {
        Film[] actual = manager.getLastAdded(10);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowPositive() {
        Film filmToAdd = new Film(30, "Dunkerk", "action");
        manager.addFilm(filmToAdd);
        Film[] actual = manager.getLastAdded(9);
        Film[] expected = {new Film(30, "Dunkerk", "action"),
                new Film(10, "Serf", "comedy"),
                new Film(9, "Good luck gentlemen", "comedy"),
                new Film(8, "Diamond hand", "comedy"),
                new Film(7, "Howl's moving castle", "fantastic"),
                new Film(6, "Avatar", "fantastic"),
                new Film(5, "Beginning", "fantastic"),
                new Film(4, "Capernaum", "drama"),
                new Film(3, "Green mile", "drama")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowNothing() {
        Film[] actual = manager.getLastAdded(0);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowAboveMax() {
        Film[] actual = manager.getLastAdded(15);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowNegative() {
        Film[] actual = manager.getLastAdded(-1);
        assertArrayEquals(expected, actual);
    }


}