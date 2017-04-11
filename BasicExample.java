/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author simu
 */
public class BasicExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create new Signal object
        Signal<Integer, String> someSignal = new Signal<>();
        
        // create new Slot, suitable for the Signal
        Signal.Slot<Integer, String> slot1 = new Signal.Slot<Integer, String>() {
            @Override
            public void call(Integer value1, String value2) {
                System.out.println("slot1: " + value1 + " " + value2);
            }
        };
        
        // connect the Slot to the Signal
        someSignal.connect(slot1);
        
        // connect a second Slot to the Signal, implementing the Slot
        // interface on the spot
        someSignal.connect(new Signal.Slot<Integer, String>() {
            @Override
            public void call(Integer value1, String value2) {
                System.out.println("slot2: " + value1 + " " + value2);
            }
        });
        
        // emit the Signal to call both Slots
        someSignal.emit(1,"Hello");

        // disconnect one of the slots
        someSignal.disconnect(slot1);

        // emit Signal again
        someSignal.emit(2,"Hello");
        
    }
    
}
