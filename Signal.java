/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 * Light weight generic class to broadcast information to other objects.<br/>
 * When a Signal is emitted, all connected Slots are executed.<br/>
 * This way of coupling controllers to the model is looser (and easier to use)
 * than extending Observable and implementing Observer.<br/>
 * This mimics, to a certain extent, the behavior of the Signals and Slots
 * in the QT framework.<br/>
 * This system of Signals and Slots is type safe because the Slot
 * interface is integrated into the Signal class.
 * @author simu
 * @param <K> type of the first transmitted information, usually the index
 * @param <V> type of the second transmitted information, usually the value
 */
public class Signal<K,V> {
    /**
     * ArrayList containing all the Slots to be executed.
     */
    private final ArrayList<Slot<K,V>> slots = new ArrayList<>();

    /**
     * Execute all Slots.
     * @param value1 first information to be transmit
     * @param value2 second information to be transmit
     */
    public void emit(K value1, V value2) {
        for (Slot<K,V> each : slots) {
                each.call(value1, value2);
        }
    }

    /**
     * Connect a Slot to a signal.<br/>
     * Add a Slot to the ArrayList.
     * @param slot the Slot to be added
     */
    public void connect(Slot<K,V> slot) {
        slots.add(slot);
    }

    /**
     * Disconnect a Slot from a signal.<br/>
     * Remove a Slot from the ArrayList.
     * @param slot the Slot to be removed
     */
    public void disconnect(Slot<K,V> slot) {
        slots.remove(slot);
    }
    
    /**
     * The interface for the Slot.
     * @param <K> type of the first transmitted information
     * @param <V> type of the second transmitted information
     */
    public interface Slot<K,V> {
        public void call(K value1, V value2);
    }
}
