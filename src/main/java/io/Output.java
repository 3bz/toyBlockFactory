package io;

import components.report.Invoice;

public interface Output {
     void giveString(String s);
     void giveOutput(Invoice i);
     void generateItemOption(String color, String shape);
}