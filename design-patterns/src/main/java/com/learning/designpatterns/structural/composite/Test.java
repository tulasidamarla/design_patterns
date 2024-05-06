package com.learning.designpatterns.structural.composite;

import com.learning.designpatterns.structural.composite.products.Book;
import com.learning.designpatterns.structural.composite.products.VideoGame;

public class Test {
    public static void main(String[] args){
        DeliveryService deliveryService = new DeliveryService();
        var game1 = new VideoGame("1", 100);
        var book1 = new Book("2", 200);
        var book2 = new Book("3", 300);
        var game2 = new VideoGame("4", 400);
        var game3 = new VideoGame("5", 500);
        deliveryService.setupOrder(
                new CompositeBox(game1),
                new CompositeBox(new CompositeBox(book1, book2),
                        game2, game3));
        System.out.println(deliveryService.calculateOrderPrice());
    }
}
