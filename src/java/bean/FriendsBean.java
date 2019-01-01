/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.faces.event.ActionEvent;
import web.Friend;
@ManagedBean(name="bean")
@SessionScoped
public class FriendsBean implements Serializable {
	private List<Friend> data; // todo list data
	private String friend; // the currently selected item value
	private String msg; // status message
        Friend f;
        ArrayList<String> friendList;
        String chosen;
                
	public FriendsBean() throws SQLException {
            
            this.friendList = getFriendList();
		loadData();
		// select the first item in the list
		this.f = data.get(0);
		setFriend(f.getName());
		setMessage(f.getName() + " selected.");
	}
	private void loadData() {
            /*
            data = new ArrayList<>();
            ArrayList<String> eventList = getEventList();
            for(int i = 0; i < eventList.size(); i++){
                Event e = new Event(eventList.get(i), String.format("%s description", eventList.get(i)));
                data.add(e);
            }*/
            
            
		data = new ArrayList<>();
                
                for(int i = 0; i < friendList.size(); i++){
                    Friend f = new Friend(friendList.get(i), String.format("%s description", friendList.get(i)));
                    data.add(f);    
                }
             /*   
                data = new ArrayList<>();
           	Event e = new Event("item 1", "item 1 description");
		data.add(e);
		e = new Event("item 2", "item 2 description");
		data.add(e);
		e = new Event("item 3", "item 3 description");
		data.add(e);
		e = new Event("item 4", "item 4 description");
		data.add(e);
               */ 
           //            AdminEventBean adb = new AdminEventBean(); //(TeacherInforRemRemote) Naming.lookup ("ava:global/CourseEJB/beans/TeacherInfoRem");

            
	}
	public List<Friend> getData() {
		return data;
	}
	public String getFriend() {
		return friend;
	}
	public void setFriend(String t) {
		this.friend = t;
	}
	// value change listener for list item selection
	public void valueChanged(ValueChangeEvent v) {
		this.chosen = (String) v.getNewValue();
		setMessage(chosen + " selected.");
	}
        public void saveListener(ActionEvent a) throws FileNotFoundException {
		setMessage(chosen + " added to cache.");
                
                try (PrintStream out = new PrintStream(new FileOutputStream("chosenFriend.txt"))) {
    out.print(chosen);
}
	}
	public void setMessage(String s) {
		msg = s;
	}
	public String getMessage() {
		return msg;
	}
        public ArrayList<String> getFriendList() throws SQLException{
        AdminFriendBean afb = new AdminFriendBean(); //(TeacherInforRemRemote) Naming.lookup ("ava:global/CourseEJB/beans/TeacherInfoRem");
        afb.init();  
        ArrayList<String> friendList = afb.getFriendsStatement();
        for(int i = 0; i < friendList.size(); i++){
            System.out.println(friendList.get(i));
        }
        afb.closeConnection();
        this.chosen = friendList.get(0);
       return friendList;
       
   }
}