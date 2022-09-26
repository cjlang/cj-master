package com.cj.core.shiro;//package com.cj.auth.shiro;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.Serializable;
//import java.text.DateFormat;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.apache.shiro.session.ExpiredSessionException;
//import org.apache.shiro.session.InvalidSessionException;
//import org.apache.shiro.session.StoppedSessionException;
//import org.apache.shiro.session.mgt.ValidatingSession;
//import org.apache.shiro.util.CollectionUtils;
//
///**
// * simpleSession不能适用json序列化问题，本来要重新，但是适用字符串序列化方式可以对session进行序列化，所以就不用了
// */
//public class CjSession implements ValidatingSession, Serializable {
//    private static final long serialVersionUID = -7125642695178165650L;
//    protected static final long MILLIS_PER_SECOND = 1000L;
//    protected static final long MILLIS_PER_MINUTE = 60000L;
//    protected static final long MILLIS_PER_HOUR = 3600000L;
//    static int bitIndexCounter = 0;
//    private static final int ID_BIT_MASK;
//    private static final int START_TIMESTAMP_BIT_MASK;
//    private static final int STOP_TIMESTAMP_BIT_MASK;
//    private static final int LAST_ACCESS_TIME_BIT_MASK;
//    private static final int TIMEOUT_BIT_MASK;
//    private static final int EXPIRED_BIT_MASK;
//    private static final int HOST_BIT_MASK;
//    private static final int ATTRIBUTES_BIT_MASK;
//    private  Serializable id;
//    private  Date startTimestamp;
//    private  Date stopTimestamp;
//    private  Date lastAccessTime;
//    private  long timeout;
//    private  boolean expired;
//    private  String host;
//    private  Map<Object, Object> attributes;
//
//    public CjSession() {
//        this.timeout = 1800000L;
//        this.startTimestamp = new Date();
//        this.lastAccessTime = this.startTimestamp;
//    }
//
//    public CjSession(String host) {
//        this();
//        this.host = host;
//    }
//
//    public Serializable getId() {
//        return this.id;
//    }
//
//    public void setId(Serializable id) {
//        this.id = id;
//    }
//
//    public Date getStartTimestamp() {
//        return this.startTimestamp;
//    }
//
//    public void setStartTimestamp(Date startTimestamp) {
//        this.startTimestamp = startTimestamp;
//    }
//
//    public Date getStopTimestamp() {
//        return this.stopTimestamp;
//    }
//
//    public void setStopTimestamp(Date stopTimestamp) {
//        this.stopTimestamp = stopTimestamp;
//    }
//
//    public Date getLastAccessTime() {
//        return this.lastAccessTime;
//    }
//
//    public void setLastAccessTime(Date lastAccessTime) {
//        this.lastAccessTime = lastAccessTime;
//    }
//
//    public boolean isExpired() {
//        return this.expired;
//    }
//
//    public void setExpired(boolean expired) {
//        this.expired = expired;
//    }
//
//    public long getTimeout() {
//        return this.timeout;
//    }
//
//    public void setTimeout(long timeout) {
//        this.timeout = timeout;
//    }
//
//    public String getHost() {
//        return this.host;
//    }
//
//    public void setHost(String host) {
//        this.host = host;
//    }
//
//    public Map<Object, Object> getAttributes() {
//        return this.attributes;
//    }
//
//    public void setAttributes(Map<Object, Object> attributes) {
//        this.attributes = attributes;
//    }
//    @JsonIgnore
//    public void touch() {
//        this.lastAccessTime = new Date();
//    }
//    @JsonIgnore
//    public void stop() {
//        if (this.stopTimestamp == null) {
//            this.stopTimestamp = new Date();
//        }
//
//    }
//    @JsonIgnore
//    protected boolean isStopped() {
//        return this.getStopTimestamp() != null;
//    }
//    @JsonIgnore
//    protected void expire() {
//        this.stop();
//        this.expired = true;
//    }
//    @JsonIgnore
//    public boolean isValid() {
//        return !this.isStopped() && !this.isExpired();
//    }
//    @JsonIgnore
//    protected boolean isTimedOut() {
//        if (this.isExpired()) {
//            return true;
//        } else {
//            long timeout = this.getTimeout();
//            if (timeout >= 0L) {
//                Date lastAccessTime = this.getLastAccessTime();
//                if (lastAccessTime == null) {
//                    String msg = "session.lastAccessTime for session with id [" + this.getId() + "] is null.  This value must be set at least once, preferably at least upon instantiation.  Please check the " + this.getClass().getName() + " implementation and ensure this value will be set (perhaps in the constructor?)";
//                    throw new IllegalStateException(msg);
//                } else {
//                    long expireTimeMillis = System.currentTimeMillis() - timeout;
//                    Date expireTime = new Date(expireTimeMillis);
//                    return lastAccessTime.before(expireTime);
//                }
//            } else {
//                return false;
//            }
//        }
//    }
//    @JsonIgnore
//    public void validate() throws InvalidSessionException {
//        if (this.isStopped()) {
//            String msg = "Session with id [" + this.getId() + "] has been explicitly stopped.  No further interaction under this session is allowed.";
//            throw new StoppedSessionException(msg);
//        } else if (this.isTimedOut()) {
//            this.expire();
//            Date lastAccessTime = this.getLastAccessTime();
//            long timeout = this.getTimeout();
//            Serializable sessionId = this.getId();
//            DateFormat df = DateFormat.getInstance();
//            String msg = "Session with id [" + sessionId + "] has expired. Last access time: " + df.format(lastAccessTime) + ".  Current time: " + df.format(new Date()) + ".  Session timeout is set to " + timeout / 1000L + " seconds (" + timeout / 60000L + " minutes)";
//            throw new ExpiredSessionException(msg);
//        }
//    }
//
//    @JsonIgnore
//    public Collection<Object> getAttributeKeys() throws InvalidSessionException {
//        Map<Object, Object> attributes = this.getAttributes();
//        return attributes == null ? Collections.emptySet() : attributes.keySet();
//    }
//
//    public Object getAttribute(Object key) {
//        Map<Object, Object> attributes = this.getAttributes();
//        return attributes == null ? null : attributes.get(key);
//    }
//
//    public void setAttribute(Object key, Object value) {
//        if (value == null) {
//            this.removeAttribute(key);
//        } else {
//
//            Map<Object, Object> attributes = this.getAttributes();
//            if (attributes == null) {
//                attributes = new HashMap();
//                this.setAttributes((Map)attributes);
//            }
//
//            ((Map)attributes).put(key, value);
//        }
//
//    }
//    @JsonIgnore
//    public Object removeAttribute(Object key) {
//        Map<Object, Object> attributes = this.getAttributes();
//        return attributes == null ? null : attributes.remove(key);
//    }
//    @JsonIgnore
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        } else if (obj instanceof org.apache.shiro.session.mgt.SimpleSession) {
//            org.apache.shiro.session.mgt.SimpleSession other = (org.apache.shiro.session.mgt.SimpleSession)obj;
//            Serializable thisId = this.getId();
//            Serializable otherId = other.getId();
//            return thisId != null && otherId != null ? thisId.equals(otherId) : this.onEquals(other);
//        } else {
//            return false;
//        }
//    }
//    @JsonIgnore
//    protected boolean onEquals(org.apache.shiro.session.mgt.SimpleSession ss) {
//        boolean var10000;
//        label65: {
//            label58: {
//                if (this.getStartTimestamp() != null) {
//                    if (!this.getStartTimestamp().equals(ss.getStartTimestamp())) {
//                        break label58;
//                    }
//                } else if (ss.getStartTimestamp() != null) {
//                    break label58;
//                }
//
//                if (this.getStopTimestamp() != null) {
//                    if (!this.getStopTimestamp().equals(ss.getStopTimestamp())) {
//                        break label58;
//                    }
//                } else if (ss.getStopTimestamp() != null) {
//                    break label58;
//                }
//
//                if (this.getLastAccessTime() != null) {
//                    if (!this.getLastAccessTime().equals(ss.getLastAccessTime())) {
//                        break label58;
//                    }
//                } else if (ss.getLastAccessTime() != null) {
//                    break label58;
//                }
//
//                if (this.getTimeout() == ss.getTimeout() && this.isExpired() == ss.isExpired()) {
//                    label60: {
//                        if (this.getHost() != null) {
//                            if (!this.getHost().equals(ss.getHost())) {
//                                break label60;
//                            }
//                        } else if (ss.getHost() != null) {
//                            break label60;
//                        }
//
//                        if (this.getAttributes() != null) {
//                            if (this.getAttributes().equals(ss.getAttributes())) {
//                                break label65;
//                            }
//                        } else if (ss.getAttributes() == null) {
//                            break label65;
//                        }
//                    }
//                }
//            }
//
//            var10000 = false;
//            return var10000;
//        }
//
//        var10000 = true;
//        return var10000;
//    }
//    @JsonIgnore
//    public int hashCode() {
//        Serializable id = this.getId();
//        if (id != null) {
//            return id.hashCode();
//        } else {
//            int hashCode = this.getStartTimestamp() != null ? this.getStartTimestamp().hashCode() : 0;
//            hashCode = 31 * hashCode + (this.getStopTimestamp() != null ? this.getStopTimestamp().hashCode() : 0);
//            hashCode = 31 * hashCode + (this.getLastAccessTime() != null ? this.getLastAccessTime().hashCode() : 0);
//            hashCode = 31 * hashCode + Long.valueOf(Math.max(this.getTimeout(), 0L)).hashCode();
//            hashCode = 31 * hashCode + Boolean.valueOf(this.isExpired()).hashCode();
//            hashCode = 31 * hashCode + (this.getHost() != null ? this.getHost().hashCode() : 0);
//            hashCode = 31 * hashCode + (this.getAttributes() != null ? this.getAttributes().hashCode() : 0);
//            return hashCode;
//        }
//    }
//    @JsonIgnore
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(this.getClass().getName()).append(",id=").append(this.getId());
//        return sb.toString();
//    }
//    @JsonIgnore
//    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.defaultWriteObject();
//        short alteredFieldsBitMask = this.getAlteredFieldsBitMask();
//        out.writeShort(alteredFieldsBitMask);
//        if (this.id != null) {
//            out.writeObject(this.id);
//        }
//
//        if (this.startTimestamp != null) {
//            out.writeObject(this.startTimestamp);
//        }
//
//        if (this.stopTimestamp != null) {
//            out.writeObject(this.stopTimestamp);
//        }
//
//        if (this.lastAccessTime != null) {
//            out.writeObject(this.lastAccessTime);
//        }
//
//        if (this.timeout != 0L) {
//            out.writeLong(this.timeout);
//        }
//
//        if (this.expired) {
//            out.writeBoolean(this.expired);
//        }
//
//        if (this.host != null) {
//            out.writeUTF(this.host);
//        }
//
//        if (!CollectionUtils.isEmpty(this.attributes)) {
//            out.writeObject(this.attributes);
//        }
//
//    }
//    @JsonIgnore
//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        in.defaultReadObject();
//        short bitMask = in.readShort();
//        if (isFieldPresent(bitMask, ID_BIT_MASK)) {
//            this.id = (Serializable)in.readObject();
//        }
//
//        if (isFieldPresent(bitMask, START_TIMESTAMP_BIT_MASK)) {
//            this.startTimestamp = (Date)in.readObject();
//        }
//
//        if (isFieldPresent(bitMask, STOP_TIMESTAMP_BIT_MASK)) {
//            this.stopTimestamp = (Date)in.readObject();
//        }
//
//        if (isFieldPresent(bitMask, LAST_ACCESS_TIME_BIT_MASK)) {
//            this.lastAccessTime = (Date)in.readObject();
//        }
//
//        if (isFieldPresent(bitMask, TIMEOUT_BIT_MASK)) {
//            this.timeout = in.readLong();
//        }
//
//        if (isFieldPresent(bitMask, EXPIRED_BIT_MASK)) {
//            this.expired = in.readBoolean();
//        }
//
//        if (isFieldPresent(bitMask, HOST_BIT_MASK)) {
//            this.host = in.readUTF();
//        }
//
//        if (isFieldPresent(bitMask, ATTRIBUTES_BIT_MASK)) {
//            this.attributes = (Map)in.readObject();
//        }
//
//    }
//    @JsonIgnore
//    private short getAlteredFieldsBitMask() {
//        int bitMask = 0;
//        bitMask = this.id != null ? bitMask | ID_BIT_MASK : bitMask;
//        bitMask = this.startTimestamp != null ? bitMask | START_TIMESTAMP_BIT_MASK : bitMask;
//        bitMask = this.stopTimestamp != null ? bitMask | STOP_TIMESTAMP_BIT_MASK : bitMask;
//        bitMask = this.lastAccessTime != null ? bitMask | LAST_ACCESS_TIME_BIT_MASK : bitMask;
//        bitMask = this.timeout != 0L ? bitMask | TIMEOUT_BIT_MASK : bitMask;
//        bitMask = this.expired ? bitMask | EXPIRED_BIT_MASK : bitMask;
//        bitMask = this.host != null ? bitMask | HOST_BIT_MASK : bitMask;
//        bitMask = !CollectionUtils.isEmpty(this.attributes) ? bitMask | ATTRIBUTES_BIT_MASK : bitMask;
//        return (short)bitMask;
//    }
//    @JsonIgnore
//    private static boolean isFieldPresent(short bitMask, int fieldBitMask) {
//        return (bitMask & fieldBitMask) != 0;
//    }
//
//    static {
//        ID_BIT_MASK = 1 << bitIndexCounter++;
//        START_TIMESTAMP_BIT_MASK = 1 << bitIndexCounter++;
//        STOP_TIMESTAMP_BIT_MASK = 1 << bitIndexCounter++;
//        LAST_ACCESS_TIME_BIT_MASK = 1 << bitIndexCounter++;
//        TIMEOUT_BIT_MASK = 1 << bitIndexCounter++;
//        EXPIRED_BIT_MASK = 1 << bitIndexCounter++;
//        HOST_BIT_MASK = 1 << bitIndexCounter++;
//        ATTRIBUTES_BIT_MASK = 1 << bitIndexCounter++;
//    }
//}