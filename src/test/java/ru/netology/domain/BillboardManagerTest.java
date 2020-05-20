package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillboardManagerTest {

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
        BillboardManager manager = new BillboardManager(10);
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowPositive() {
        BillboardManager manager = new BillboardManager(9);
        Film filmToAdd = new Film(30, "Dunkerk", "action");
        manager.addFilm(filmToAdd);
        Film[] actual = manager.getLastAdded();
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
        BillboardManager manager = new BillboardManager(0);
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowAboveMax() {
        BillboardManager manager = new BillboardManager(15);
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowNegative() {
        BillboardManager manager = new BillboardManager(-1);
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }
}

