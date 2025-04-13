package org.parkingManagement;

import java.util.concurrent.atomic.AtomicInteger;

class TicketGenerator {
    private static AtomicInteger counter = new AtomicInteger(1000);

    public static int generateTicketNumber() {
        return counter.getAndIncrement();
    }
}