package navx.energy.exception;

// RuntimeException means we don't have to add "throws" everywhere in our code!
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
