package com.company.managers;

import com.company.dao.SessionDAO;
import com.company.entity.Session;
import com.company.enums.SessionState;
import com.company.request.CreateSessionReq;

import java.util.List;
import java.util.Objects;

public class SessionManager {

    private final SessionDAO sessionDAO;

    public SessionManager(SessionDAO sessionDAO) {
        this.sessionDAO = sessionDAO;
    }

    public void createSession(CreateSessionReq createSessionReq) {

        Session session = new Session(createSessionReq.getId(), createSessionReq.getCentreId(),
                createSessionReq.getDayStartTime(), createSessionReq.getStartingSlot(), createSessionReq.getEndingSlot(),
                createSessionReq.getTotalSeats(), createSessionReq.getSessionType());
        sessionDAO.addSession(session);
    }

    public List<Session> getAllSessions() {
        return sessionDAO.getAllSessions();
    }

    public boolean seatsRemainingForSession(String sessionId) {
        Session session = sessionDAO.getSessionById(sessionId);

        if (Objects.nonNull(session)) {
            return session.getSeatsVacant() > 0;
        }

        return false;
    }

    // todo check for transactions
    public boolean decrementSeatsVacantForSession(String id) {
        Session session = sessionDAO.getSessionById(id);
        if (Objects.nonNull(session) && session.getSeatsVacant() > 0) {
            session.setSeatsVacant(session.getSeatsVacant()-1);
            sessionDAO.updateSession(session);
            return true;
        }
        return false;
    }

}
