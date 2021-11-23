package ch.sjost.jsobra.matliste.exceptions;

public class MaterialNotFoundException extends RuntimeException{

    public MaterialNotFoundException(Long id) {
        super("Could not find material "+id);
    }
}
