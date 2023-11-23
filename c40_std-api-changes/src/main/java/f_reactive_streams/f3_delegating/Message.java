package f_reactive_streams.f3_delegating;

public class Message {

    public final int sequenceNumber;

    public Message(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " [sequenceNumber=" + sequenceNumber + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + sequenceNumber;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Message other = (Message) obj;
        if (sequenceNumber != other.sequenceNumber) {
            return false;
        }
        return true;
    }

}
