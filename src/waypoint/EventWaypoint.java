package waypoint;

public interface EventWaypoint {

    public void selected(MyWaypoint waypoint);

    public void remove(MyWaypoint aThis);

    public void add(MyWaypoint newWaypoint);
}
