package io;

import services.reporting.Invoice;

public interface IOutput {
     void giveString(String s);
     void giveOutput(Invoice i);
     void generateItemOption(String color, String shape);
}