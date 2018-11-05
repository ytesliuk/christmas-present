package model.entities.present_containers;

/**
 * Implementing this interface allows an object to be a container for present items in present.
 */
public interface IPresentContainer {
    /**
     * Returns the maximum weight which present container can hold
     * @returnthe maximum weight which present container can hold
     */
    int getMaxWeight();

}
