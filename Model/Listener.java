package Model;

/**
 * This interface is to be inherited by the various View components to ensure that they update when the Model updates
 */
public interface Listener {
    void updated();
}
