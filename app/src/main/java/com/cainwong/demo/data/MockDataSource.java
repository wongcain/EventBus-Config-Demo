package com.cainwong.demo.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by cwong on 1/27/15.
 */
public class MockDataSource {

    static final String BODY_TEXT = "Crow's nest bounty square-rigged starboard case shot nipper Sail ho Corsair Davy Jones' Locker sheet. Chantey brig overhaul walk the plank grog blossom rutters lookout Pieces of Eight lass Sea Legs. Hail-shot aft pinnace Chain Shot parley quarterdeck swab Letter of Marque belay coxswain. \n" +
            "\n" +
            "Crack Jennys tea cup snow piracy man-of-war fluke Sail ho Arr aye pinnace bounty. Run a shot across the bow jib hulk brigantine prow piracy avast reef sails Arr belay. Bring a spring upon her cable reef dead men tell no tales brigantine scourge of the seven seas gunwalls yawl tender jury mast mizzenmast. \n" +
            "\n" +
            "Rigging cable provost sheet case shot stern carouser trysail squiffy cackle fruit. Maroon Jack Ketch gibbet lateen sail Letter of Marque gangway log Jolly Roger Chain Shot spirits. Scourge of the seven seas Sink me lass quarter hearties list gunwalls keel parrel black jack. \n" +
            "\n" +
            "Aye clipper red ensign line run a shot across the bow spyglass Nelsons folly tender Gold Road galleon. Jolly boat lookout doubloon wench measured fer yer chains marooned handsomely long boat dance the hempen jig landlubber or just lubber. Weigh anchor hulk fire ship tender pirate spirits topsail sloop gun boom.";

    public static final List<Item> ITEMS = new ArrayList<>();

    static{
        long now = System.currentTimeMillis();
        for(int i=0; i<20; i++){
            ITEMS.add(new Item("Pirate Log Entry "  + i, BODY_TEXT, new Date(now - (i*24*60*60*1000))));
        }
    }

}
