package com.example.commondto.event;

import java.util.Date;
import java.util.UUID;

public interface Event {
	public UUID getEventId();

	public Date getDate();
}
