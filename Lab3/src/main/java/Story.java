import Classes.*;
import Enums.Role;

import java.util.ArrayList;
import java.util.List;

public class Story {
    public static void main(String[] args) {
        DubeSpeaker dubeSpeaker = new DubeSpeaker(Role.VILLAIN, "Dube", 3);
        DubeEarner dubeEarner = new DubeEarner(Role.VILLAIN, "Dube", 3);
        SprootsSpeaker sprootsSpeaker = new SprootsSpeaker(Role.VILLAIN, "Sproots", 5);
        SprootsEarner sprootsEarner = new SprootsEarner(Role.VILLAIN, "Sproots", 5);
        NeznaykaSpeaker neznaykaSpeaker = new NeznaykaSpeaker(Role.HERO, "Neznayka");
        JulioSpeaker julioSpeaker = new JulioSpeaker(Role.NEUTRAL_CHARACTER, "Julio");
        MigoSpeaker migoSpeaker = new MigoSpeaker(Role.NEUTRAL_CHARACTER, "Migo");
        KozlikSpeaker kozlikSpeaker = new KozlikSpeaker(Role.HERO, "Kozlik");

        System.out.println(dubeSpeaker);
        dubeSpeaker.speak();
        dubeEarner.earn();

        System.out.println(sprootsSpeaker);
        sprootsSpeaker.speak();
        sprootsEarner.earn();

        System.out.println(dubeSpeaker.equals(dubeEarner));
        System.out.println(sprootsSpeaker.equals(sprootsEarner));

        System.out.println(neznaykaSpeaker);
        neznaykaSpeaker.speak();

        System.out.println(kozlikSpeaker);
        kozlikSpeaker.speak();

        System.out.println(julioSpeaker);
        julioSpeaker.speak();

        System.out.println(migoSpeaker);
        migoSpeaker.speak();

    }
    
}
