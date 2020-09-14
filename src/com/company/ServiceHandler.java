package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiceHandler {
    ArrayList<KEAService> serviceList;
    public ServiceHandler(FredagsbarService fredagsbarService, KeaKillKlubService keaKillKlubService, SpritService spritService, AshtrayService ashtrayService, LyingCakeDispenserService lyingCakeDispenserService){
        boolean ashtrayEnding = false;
        do {
            Scanner inputscanner = new Scanner(System.in);
            //Prompt starts here
            System.out.println("Welcome back to KEA Services, Commander. Please enter the service you would like to run.");
            String match = inputscanner.nextLine();

            switch (match) {
                case "Fredagsbar":
                    System.out.println("Excellent choice, commander. I am quite parched myself.");
                    fredagsbarService.cheers();
                    break;
                case "Kill Klub":
                    System.out.println("Ah, I see, Commander, it's time to deal with those pesky infected.");
                    keaKillKlubService.clean_machine();
                    break;
                case "Lying Cake Dispenser":
                    System.out.println("Good choice, Commander. It's always time for cake. Isn't it?");
                    lyingCakeDispenserService.dispense();
                    break;
                case "Sprit Service":
                    System.out.println("Clever choice, Commander. Always remember to sanitize.");
                    spritService.sanitize();
                    break;
                case "Askebæger":
                    System.out.println("It's that time again, huh Commander?");
                    System.out.println("Is your current ashtray full? (y/n)");
                    Scanner prompt = new Scanner(System.in);
                    String answer = prompt.nextLine();
                    if (answer.equals("y")) {
                        ashtrayService.emptyAshtray();
                        break;
                    } else if (answer.equals("n")) {
                        ashtrayService.callOverAshtray();
                        break;
                    } else {
                        System.out.println("I did not understand that. Intruder detected.\nLocking down KEA.");
                        ashtrayService.lockKea();
                        ashtrayEnding = true;
                        break;
                    }
                default:
                    System.out.println("I did not quite understand that, Commander, please try one of the following:");
                    System.out.println("Fredagsbar");
                    System.out.println("Kill Klub");
                    System.out.println("Lying Cake Dispenser");
                    System.out.println("Sprit Service");
                    System.out.println("Askebæger");
                    System.out.println();
            }
        } while (!ashtrayEnding);

    }

    public ServiceHandler(ArrayList<KEAService> list){
        serviceList = list;
    }

    public void searchList(String quote){
        for(KEAService service : serviceList){
            if(quote.equals(service.name)) {
                System.out.println("Service found!: " + service.name);
                service.run();
            }

        }
    }


}
