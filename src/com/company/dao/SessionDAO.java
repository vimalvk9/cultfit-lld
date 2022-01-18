package com.company.dao;

import com.company.entity.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class SessionDAO {

    private HashMap<String, Session> sessionMap = new HashMap<>();

    public void addSession(Session session) {
        if (Objects.nonNull(session)) {
            sessionMap.put(session.getId(), session);
        }
    }

    public void updateSession(Session session) {
        sessionMap.put(session.getId(), session);
    }

    public Session getSessionById(String id) {
        return sessionMap.getOrDefault(id, null);
    }

    public List<Session> getAllSessions() {
        return new ArrayList<>(sessionMap.values());
    }
}
