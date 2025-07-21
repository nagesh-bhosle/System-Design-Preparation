class DVDplayer {
    public void play() {
        System.out.println("Playing DVD...");
    }

    public void stop() {
        System.out.println("Stopping DVD...");
    }
}

class Projector {
    public void turnOn() {
        System.out.println("Projector is now ON.");
    }

    public void turnOff() {
        System.out.println("Projector is now OFF.");
    }
}

class SoundSystem {
    public void setVolume(int level) {
        System.out.println("Setting sound system volume to " + level);
    }

    public void mute() {
        System.out.println("Sound system is muted.");
    }
}

class Screen {
    public void lower() {
        System.out.println("Lowering screen...");
    }

    public void raise() {
        System.out.println("Raising screen...");
    }
}

class HomeTheaterFacade {
    private DVDplayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;
    private Screen screen;

    public HomeTheaterFacade() {
        dvdPlayer = new DVDplayer();
        projector = new Projector();
        soundSystem = new SoundSystem();
        screen = new Screen();
    }

    public void watchMovie() {
        screen.lower();
        projector.turnOn();
        soundSystem.setVolume(5);
        dvdPlayer.play();
    }

    public void endMovie() {
        dvdPlayer.stop();
        soundSystem.mute();
        projector.turnOff();
        screen.raise();
    }
}

public class FacadeDP {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();
        
        System.out.println("Starting movie...");
        homeTheater.watchMovie();
        
        System.out.println("\nEnding movie...");
        homeTheater.endMovie();
    }
}