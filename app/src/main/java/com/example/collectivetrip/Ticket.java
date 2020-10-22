package com.example.collectivetrip;

import com.example.collectivetrip.Participant;

import java.util.Date;
import java.util.Vector;

public class Ticket {
    private Vector<Participant> participants;
    private Date date;
    private String name;


    public Ticket()
    {

    }

    public void AddParticipant(Participant participant)
    {
        participants.add(participant);
    }
    public void RemoveParticipant(Participant participant)
    {
        participants.remove(participant);
    }


}
