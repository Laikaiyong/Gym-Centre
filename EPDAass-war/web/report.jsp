<%-- 
    Document   : report
    Created on : 23 May 2024, 9:51:57 pm
    Author     : vandycklai
--%>

<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.Feedback"%>
<%@page import="model.Comment"%>
<%@page import="model.GymClass"%>
<%@page import="model.GymClass"%>
<%@page import="model.Inventory"%>
<%@page import="model.Staff"%>
<%@page import="model.Trainer"%>
<%@page import="java.util.List"%>
<%@page import="model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    List<Customer> customers = (List<Customer>) request.getAttribute("customers");
    List<Trainer> trainers = (List<Trainer>) request.getAttribute("trainers");
    List<Staff> staffs = (List<Staff>) request.getAttribute("staffs");
    List<GymClass> gymClasses = (List<GymClass>) request.getAttribute("gymClasses");
    List<Inventory> inventories = (List<Inventory>) request.getAttribute("inventories");
    List<Comment> comments = (List<Comment>) request.getAttribute("comments");
    List<Feedback> feedbacks = (List<Feedback>) request.getAttribute("feedbacks");
    
    Integer male = 0;
    Integer female = 0;
    Map ageCounts = new HashMap();
        List<String> agekeys = new ArrayList();
        List<Integer> agevalues = new ArrayList();
    Map locationCounts = new HashMap();
        List<String> locationkeys = new ArrayList();
        List<Integer> locationvalues = new ArrayList();
    Map nationCounts = new HashMap();
        List<String> nationkeys = new ArrayList();
        List<Integer> nationvalues = new ArrayList();
    Map heightCounts = new HashMap();
        List<String> heightkeys = new ArrayList();
        List<Integer> heightvalues = new ArrayList();
    Map weightCounts = new HashMap();
        List<String> weightkeys = new ArrayList();
        List<Integer> weightvalues = new ArrayList();

    for (Customer customer: customers) {
if (ageCounts.containsKey(Integer.toString(customer.getAge()))) {
                int count = ((Integer) ageCounts.get(Integer.toString(customer.getAge()))).intValue();
                ageCounts.put(Integer.toString(customer.getAge()), count + 1);
            } else {
                ageCounts.put(Integer.toString(customer.getAge()), 1);
            }
if (locationCounts.containsKey(customer.getLocation())) {
                int count = ((Integer) locationCounts.get(customer.getLocation())).intValue();
                locationCounts.put(customer.getLocation(), count + 1);
            } else {
                locationCounts.put(customer.getLocation(), 1);
            }
if (nationCounts.containsKey(customer.getNation())) {
                int count = ((Integer) nationCounts.get(customer.getNation())).intValue();
                nationCounts.put(customer.getNation(), count + 1);
            } else {
                nationCounts.put(customer.getNation(), 1);
            }
if (heightCounts.containsKey(Integer.toString(customer.getHeight()))) {
                int count = ((Integer) heightCounts.get(Integer.toString(customer.getHeight()))).intValue();
                heightCounts.put(Integer.toString(customer.getHeight()), count + 1);
            } else {
                heightCounts.put(Integer.toString(customer.getHeight()), 1);
            }
if (weightCounts.containsKey(Integer.toString(customer.getWeight()))) {
                int count = ((Integer) weightCounts.get(Integer.toString(customer.getWeight()))).intValue();
                weightCounts.put(Integer.toString(customer.getWeight()), count + 1);
            } else {
                weightCounts.put(Integer.toString(customer.getWeight()), 1);
            }
        if (customer.getGender().equals("Female")) {
            female++;
        } else {
            male++;
        }
    }
    for (Trainer trainer: trainers) {
if (ageCounts.containsKey(Integer.toString(trainer.getAge()))) {
                int count = ((Integer) ageCounts.get(Integer.toString(trainer.getAge()))).intValue();
                ageCounts.put(Integer.toString(trainer.getAge()), count + 1);
            } else {
                ageCounts.put(Integer.toString(trainer.getAge()), 1);
            }
            
            if (locationCounts.containsKey(trainer.getLocation())) {
                int count = ((Integer) locationCounts.get(trainer.getLocation())).intValue();
                locationCounts.put(trainer.getLocation(), count + 1);
            } else {
                locationCounts.put(trainer.getLocation(), 1);
            }
if (nationCounts.containsKey(trainer.getNation())) {
                int count = ((Integer) nationCounts.get(trainer.getNation())).intValue();
                nationCounts.put(trainer.getNation(), count + 1);
            } else {
                nationCounts.put(trainer.getNation(), 1);
            }
if (heightCounts.containsKey(Integer.toString(trainer.getHeight()))) {
                int count = ((Integer) heightCounts.get(Integer.toString(trainer.getHeight()))).intValue();
                heightCounts.put(Integer.toString(trainer.getHeight()), count + 1);
            } else {
                heightCounts.put(Integer.toString(trainer.getHeight()), 1);
            }
if (weightCounts.containsKey(Integer.toString(trainer.getWeight()))) {
                int count = ((Integer) weightCounts.get(Integer.toString(trainer.getWeight()))).intValue();
                weightCounts.put(Integer.toString(trainer.getWeight()), count + 1);
            } else {
                weightCounts.put(Integer.toString(trainer.getWeight()), 1);
    }
        if (trainer.getGender().equals("Female")) {
            female++;
        } else {
            male++;
        }
    }
    for (Staff staff: staffs) {
if (ageCounts.containsKey(Integer.toString(staff.getAge()))) {
                int count = ((Integer) ageCounts.get(Integer.toString(staff.getAge()))).intValue();
                ageCounts.put(Integer.toString(staff.getAge()), count + 1);
            } else {
                ageCounts.put(Integer.toString(staff.getAge()), 1);
            }
                        if (locationCounts.containsKey(staff.getLocation())) {
                int count = ((Integer) locationCounts.get(staff.getLocation())).intValue();
                locationCounts.put(staff.getLocation(), count + 1);
            } else {
                locationCounts.put(staff.getLocation(), 1);
            }
if (nationCounts.containsKey(staff.getNation())) {
                int count = ((Integer) nationCounts.get(staff.getNation())).intValue();
                nationCounts.put(staff.getNation(), count + 1);
            } else {
                nationCounts.put(staff.getNation(), 1);
            }
if (heightCounts.containsKey(Integer.toString(staff.getHeight()))) {
                int count = ((Integer) heightCounts.get(Integer.toString(staff.getHeight()))).intValue();
                heightCounts.put(Integer.toString(staff.getHeight()), count + 1);
            } else {
                heightCounts.put(Integer.toString(staff.getHeight()), 1);
            }
if (weightCounts.containsKey(Integer.toString(staff.getWeight()))) {
                int count = ((Integer) weightCounts.get(Integer.toString(staff.getWeight()))).intValue();
                weightCounts.put(Integer.toString(staff.getWeight()), count + 1);
            } else {
                weightCounts.put(Integer.toString(staff.getWeight()), 1);
    }
        if (staff.getGender().equals("Female")) {
            female++;
        } else {
            male++;
        }
    }
    
        for (Iterator it = ageCounts.entrySet().iterator(); it.hasNext(); ) {
            Entry entry = (Entry) it.next();
            agekeys.add(entry.getKey().toString());
            agevalues.add(Integer.parseInt(entry.getValue().toString()));
        }
    
        for (Iterator it = locationCounts.entrySet().iterator(); it.hasNext(); ) {
            Entry entry = (Entry) it.next();
            locationkeys.add(entry.getKey().toString());
            locationvalues.add(Integer.parseInt(entry.getValue().toString()));
        }
    
        for (Iterator it = nationCounts.entrySet().iterator(); it.hasNext(); ) {
            Entry entry = (Entry) it.next();
            nationkeys.add(entry.getKey().toString());
            nationvalues.add(Integer.parseInt(entry.getValue().toString()));
        }
    
        for (Iterator it = heightCounts.entrySet().iterator(); it.hasNext(); ) {
            Entry entry = (Entry) it.next();
            heightkeys.add(entry.getKey().toString());
            heightvalues.add(Integer.parseInt(entry.getValue().toString()));
        }
    
        for (Iterator it = ageCounts.entrySet().iterator(); it.hasNext(); ) {
            Entry entry = (Entry) it.next();
            weightkeys.add(entry.getKey().toString());
            weightvalues.add(Integer.parseInt(entry.getValue().toString()));
        }
    
       Map gymFees = new HashMap();
        List<String> gymFeeskeys = new ArrayList();
        List<Integer> gymFeesvalues = new ArrayList();
    for (GymClass gym: gymClasses) {
        if (gymFees.containsKey(gym.getClassStatus())) {
                int fees = ((Integer) gymFees.get(gym.getClassStatus())).intValue();
                gymFees.put(gym.getClassStatus(), fees + gym.getFee());
    } else {
               gymFees.put(gym.getClassStatus(), gym.getFee());
            }}
            for (Iterator it = gymFees.entrySet().iterator(); it.hasNext(); ) {
            Entry entry = (Entry) it.next();
            gymFeeskeys.add(entry.getKey().toString());
            gymFeesvalues.add(Integer.parseInt(entry.getValue().toString()));
        }
    
       Map rating = new HashMap();
        List<String> ratingkeys = new ArrayList();
        List<Integer> ratingvalues = new ArrayList();
    for (Comment comment: comments) {
        if (rating.containsKey(comment.getRating())) {
                int count = ((Integer) rating.get(comment.getRating())).intValue();
                rating.put(comment.getRating(), count + 1);
    } else {
               rating.put(comment.getRating(), 1);
            }}
            for (Iterator it = rating.entrySet().iterator(); it.hasNext(); ) {
            Entry entry = (Entry) it.next();
            ratingkeys.add(entry.getKey().toString());
            ratingvalues.add(Integer.parseInt(entry.getValue().toString()));
        }

StringBuffer gymFeeskeysJson = new StringBuffer("[");
        for (int i = 0; i < gymFeeskeys.size(); i++) {
          gymFeeskeysJson.append("\"").append(gymFeeskeys.get(i)).append("\"");
            if (i < gymFeeskeys.size() - 1) {
                gymFeeskeysJson.append(",");
            }
        }
        gymFeeskeysJson.append("]");
StringBuffer locationkeysJson = new StringBuffer("[");
        for (int i = 0; i < locationkeys.size(); i++) {
          locationkeysJson.append("\"").append(locationkeys.get(i)).append("\"");
            if (i < locationkeys.size() - 1) {
                locationkeysJson.append(",");
            }
        }
        locationkeysJson.append("]");
StringBuffer nationkeysJson = new StringBuffer("[");
        for (int i = 0; i < nationkeys.size(); i++) {
          nationkeysJson.append("\"").append(nationkeys.get(i)).append("\"");
            if (i < nationkeys.size() - 1) {
                nationkeysJson.append(",");
            }
        }
        nationkeysJson.append("]");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report Page</title>
                <link rel="icon" type="image/x-icon" href="https://www.iconarchive.com/download/i99767/sonya/swarm/gym.ico">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.css"  rel="stylesheet" />
    </head>
    <body>
 <button data-drawer-target="default-sidebar" data-drawer-toggle="default-sidebar" aria-controls="default-sidebar" type="button" class="inline-flex items-center p-2 mt-2 ml-3 text-sm text-gray-500 rounded-lg sm:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600">
            <span class="sr-only">Open sidebar</span>
            <svg class="w-6 h-6" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
            <path clip-rule="evenodd" fill-rule="evenodd" d="M2 4.75A.75.75 0 012.75 4h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 4.75zm0 10.5a.75.75 0 01.75-.75h7.5a.75.75 0 010 1.5h-7.5a.75.75 0 01-.75-.75zM2 10a.75.75 0 01.75-.75h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 10z"></path>
            </svg>
        </button>

        <aside id="default-sidebar" class="fixed top-0 left-0 z-40 w-64 h-screen transition-transform -translate-x-full sm:translate-x-0" aria-label="Sidenav">
            <div class="overflow-y-auto py-5 px-3 h-full bg-white border-r border-gray-200 dark:bg-gray-800 dark:border-gray-700">
                <ul class="space-y-2">
                    <li>
                        <a href="home.jsp" class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
                            <svg aria-hidden="true" class="w-6 h-6 text-gray-400 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path d="M2 10a8 8 0 018-8v8h8a8 8 0 11-16 0z"></path><path d="M12 2.252A8.014 8.014 0 0117.748 8H12V2.252z"></path></svg>
                            <span class="ml-3">Home</span>
                        </a>
                    </li>
                    <%
                        if (session.getAttribute("userRole") == "staff") {
                    %><li>
                        <a href="report" class="flex items-center p-2 w-full text-base font-normal text-gray-900 rounded-lg transition duration-75 group hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700" aria-controls="dropdown-pages" data-collapse-toggle="dropdown-pages">
                            <svg aria-hidden="true" class="flex-shrink-0 w-6 h-6 text-gray-400 transition duration-75 group-hover:text-gray-900 dark:text-gray-400 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4 4a2 2 0 012-2h4.586A2 2 0 0112 2.586L15.414 6A2 2 0 0116 7.414V16a2 2 0 01-2 2H6a2 2 0 01-2-2V4zm2 6a1 1 0 011-1h6a1 1 0 110 2H7a1 1 0 01-1-1zm1 3a1 1 0 100 2h6a1 1 0 100-2H7z" clip-rule="evenodd"></path></svg>
                            <span class="flex-1 ml-3 text-left whitespace-nowrap">Report</span>

                        </a>
                    </li><%}%>
                    <li>
                        <button type="button" class="flex items-center p-2 w-full text-base font-normal text-gray-900 rounded-lg transition duration-75 group hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700" aria-controls="dropdown-sales" data-collapse-toggle="dropdown-sales">
                            <svg aria-hidden="true" class="flex-shrink-0 w-6 h-6 text-gray-400 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path d="M8.707 7.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l2-2a1 1 0 00-1.414-1.414L11 7.586V3a1 1 0 10-2 0v4.586l-.293-.293z"></path><path d="M3 5a2 2 0 012-2h1a1 1 0 010 2H5v7h2l1 2h4l1-2h2V5h-1a1 1 0 110-2h1a2 2 0 012 2v10a2 2 0 01-2 2H5a2 2 0 01-2-2V5z"></path></svg>
                            <span class="flex-1 ml-3 text-left whitespace-nowrap">Management</span>
                            <svg aria-hidden="true" class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M5.293 7.293a1 1 0 011.414 0L10 10.586l3.293-3.293a1 1 0 111.414 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                        </button>
                        <ul id="dropdown-sales" class="hidden py-2 space-y-2">
                            <%
                                  if (session.getAttribute("userRole") != null) {
                                    if ("staff|superadmin".contains(session.getAttribute("userRole").toString())) {
                            %><li>
                                <a href="users" class="flex items-center p-2 pl-11 w-full text-base font-normal text-gray-900 rounded-lg transition duration-75 group hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700">Users</a>
                            </li><%}}%>
 
                            <%
                                if (session.getAttribute("userRole") != null) {
                                    if ("staff|trainer|customer".contains(session.getAttribute("userRole").toString())) {
                            %><li>
                                <a href="class" class="flex items-center p-2 pl-11 w-full text-base font-normal text-gray-900 rounded-lg transition duration-75 group hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700">Class</a>
                            </li><%}
                                }%>
       
                            <%
                                if (session.getAttribute("userRole").toString().equals("trainer")) {
                            %><li>
                                <a href="feedback" class="flex items-center p-2 pl-11 w-full text-base font-normal text-gray-900 rounded-lg transition duration-75 group hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700">Feedback</a>
                            </li><%}%>
                            <%
                                if (session.getAttribute("userRole").toString().equals("customer")) {
                            %><li>
                                <a href="comment" class="flex items-center p-2 pl-11 w-full text-base font-normal text-gray-900 rounded-lg transition duration-75 group hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700">Comment</a>
                            </li><%}%>
                        </ul>
                    </li>
                    <li>
                        <button type="button" class="flex items-center p-2 w-full text-base font-normal text-gray-900 rounded-lg transition duration-75 group hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700" aria-controls="dropdown-authentication" data-collapse-toggle="dropdown-authentication">
                            <svg aria-hidden="true" class="flex-shrink-0 w-6 h-6 text-gray-400 transition duration-75 group-hover:text-gray-900 dark:text-gray-400 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M5 9V7a5 5 0 0110 0v2a2 2 0 012 2v5a2 2 0 01-2 2H5a2 2 0 01-2-2v-5a2 2 0 012-2zm8-2v2H7V7a3 3 0 016 0z" clip-rule="evenodd"></path></svg>
                            <span class="flex-1 ml-3 text-left whitespace-nowrap">Authentication</span>
                            <svg aria-hidden="true" class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M5.293 7.293a1 1 0 011.414 0L10 10.586l3.293-3.293a1 1 0 111.414 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                        </button>
                        <ul id="dropdown-authentication" class="hidden py-2 space-y-2">
                             <%
                                if (session.getAttribute("userRole") != null) {
                                    if ("staff|trainer|customer".contains(session.getAttribute("userRole").toString())) {
                            %><li>
                                <a href="profile" class="flex items-center p-2 pl-11 w-full text-base font-normal text-gray-900 rounded-lg transition duration-75 group hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700">Profile</a>
                            </li><%}}%>
                            <li>
                                <form action="Logout" method="POST">
                                    <button type="submit" value="Logout" class="flex items-center p-2 pl-11 w-full text-base font-normal text-gray-900 rounded-lg transition duration-75 group hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700">Sign Out</button>
                                </form>

                            </li>
                        </ul>
                    </li>
                </ul>
                <ul class="pt-5 mt-5 space-y-2 border-t border-gray-200 dark:border-gray-700">
                    <li>
                        <a href="#" class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg transition duration-75 hover:bg-gray-100 dark:hover:bg-gray-700 dark:text-white group">
                            <svg aria-hidden="true" class="flex-shrink-0 w-6 h-6 text-gray-400 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path d="M7 3a1 1 0 000 2h6a1 1 0 100-2H7zM4 7a1 1 0 011-1h10a1 1 0 110 2H5a1 1 0 01-1-1zM2 11a2 2 0 012-2h12a2 2 0 012 2v4a2 2 0 01-2 2H4a2 2 0 01-2-2v-4z"></path></svg>
                            <span class="ml-3">Role: <%=session.getAttribute("userRole")%></span>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="hidden absolute bottom-0 left-0 justify-center p-4 space-x-4 w-full lg:flex bg-white dark:bg-gray-800 z-20 border-r border-gray-200 dark:border-gray-700">
                <a href="#" class="inline-flex justify-center p-2 text-gray-500 rounded cursor-pointer dark:text-gray-400 hover:text-gray-900 dark:hover:text-white hover:bg-gray-100 dark:hover:bg-gray-600">
                    <svg aria-hidden="true" class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path d="M5 4a1 1 0 00-2 0v7.268a2 2 0 000 3.464V16a1 1 0 102 0v-1.268a2 2 0 000-3.464V4zM11 4a1 1 0 10-2 0v1.268a2 2 0 000 3.464V16a1 1 0 102 0V8.732a2 2 0 000-3.464V4zM16 3a1 1 0 011 1v7.268a2 2 0 010 3.464V16a1 1 0 11-2 0v-1.268a2 2 0 010-3.464V4a1 1 0 011-1z"></path></svg>
                </a>
                <a href="#" data-tooltip-target="tooltip-settings" class="inline-flex justify-center p-2 text-gray-500 rounded cursor-pointer dark:text-gray-400 dark:hover:text-white hover:text-gray-900 hover:bg-gray-100 dark:hover:bg-gray-600">
                    <svg aria-hidden="true" class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M11.49 3.17c-.38-1.56-2.6-1.56-2.98 0a1.532 1.532 0 01-2.286.948c-1.372-.836-2.942.734-2.106 2.106.54.886.061 2.042-.947 2.287-1.561.379-1.561 2.6 0 2.978a1.532 1.532 0 01.947 2.287c-.836 1.372.734 2.942 2.106 2.106a1.532 1.532 0 012.287.947c.379 1.561 2.6 1.561 2.978 0a1.533 1.533 0 012.287-.947c1.372.836 2.942-.734 2.106-2.106a1.533 1.533 0 01.947-2.287c1.561-.379 1.561-2.6 0-2.978a1.532 1.532 0 01-.947-2.287c.836-1.372-.734-2.942-2.106-2.106a1.532 1.532 0 01-2.287-.947zM10 13a3 3 0 100-6 3 3 0 000 6z" clip-rule="evenodd"></path></svg>
                </a>
                <div id="tooltip-settings" role="tooltip" class="inline-block absolute invisible z-10 py-2 px-3 text-sm font-medium text-white bg-gray-900 rounded-lg shadow-sm opacity-0 transition-opacity duration-300 tooltip">
                    Settings page
                    <div class="tooltip-arrow" data-popper-arrow></div>
                </div>
                <button type="button" data-dropdown-toggle="language-dropdown" class="inline-flex justify-center p-2 text-gray-500 rounded cursor-pointer dark:hover:text-white dark:text-gray-400 hover:text-gray-900 hover:bg-gray-100 dark:hover:bg-gray-600">
                    <svg aria-hidden="true" class="h-5 w-5 rounded-full mt-0.5" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 3900 3900"><path fill="#b22234" d="M0 0h7410v3900H0z"/><path d="M0 450h7410m0 600H0m0 600h7410m0 600H0m0 600h7410m0 600H0" stroke="#fff" stroke-width="300"/><path fill="#3c3b6e" d="M0 0h2964v2100H0z"/><g fill="#fff"><g id="d"><g id="c"><g id="e"><g id="b"><path id="a" d="M247 90l70.534 217.082-184.66-134.164h228.253L176.466 307.082z"/><use xlink:href="#a" y="420"/><use xlink:href="#a" y="840"/><use xlink:href="#a" y="1260"/></g><use xlink:href="#a" y="1680"/></g><use xlink:href="#b" x="247" y="210"/></g><use xlink:href="#c" x="494"/></g><use xlink:href="#d" x="988"/><use xlink:href="#c" x="1976"/><use xlink:href="#e" x="2470"/></g></svg>
                </button>
                <!-- Dropdown -->
                <div class="hidden z-50 my-4 text-base list-none bg-white rounded divide-y divide-gray-100 shadow dark:bg-gray-700" id="language-dropdown">
                    <ul class="py-1" role="none">
                        <li>
                            <a href="#" class="block py-2 px-4 text-sm text-gray-700 hover:bg-gray-100 dark:hover:text-white dark:text-gray-300 dark:hover:bg-gray-600" role="menuitem">
                                <div class="inline-flex items-center">
                                    <svg aria-hidden="true" class="h-3.5 w-3.5 rounded-full mr-2" xmlns="http://www.w3.org/2000/svg" id="flag-icon-css-us" viewBox="0 0 512 512">
                                    <g fill-rule="evenodd">
                                    <g stroke-width="1pt">
                                    <path fill="#bd3d44" d="M0 0h247v10H0zm0 20h247v10H0zm0 20h247v10H0zm0 20h247v10H0zm0 20h247v10H0zm0 20h247v10H0zm0 20h247v10H0z" transform="scale(3.9385)"/>
                                    <path fill="#fff" d="M0 10h247v10H0zm0 20h247v10H0zm0 20h247v10H0zm0 20h247v10H0zm0 20h247v10H0zm0 20h247v10H0z" transform="scale(3.9385)"/>
                                    </g>
                                    <path fill="#192f5d" d="M0 0h98.8v70H0z" transform="scale(3.9385)"/>
                                    <path fill="#fff" d="M8.2 3l1 2.8H12L9.7 7.5l.9 2.7-2.4-1.7L6 10.2l.9-2.7-2.4-1.7h3zm16.5 0l.9 2.8h2.9l-2.4 1.7 1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7h2.9zm16.5 0l.9 2.8H45l-2.4 1.7 1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7h2.9zm16.4 0l1 2.8h2.8l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h3zm16.5 0l.9 2.8h2.9l-2.4 1.7 1 2.7L74 8.5l-2.3 1.7.9-2.7-2.4-1.7h2.9zm16.5 0l.9 2.8h2.9L92 7.5l1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7h2.9zm-74.1 7l.9 2.8h2.9l-2.4 1.7 1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7h2.9zm16.4 0l1 2.8h2.8l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h3zm16.5 0l.9 2.8h2.9l-2.4 1.7 1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7h2.9zm16.5 0l.9 2.8h2.9l-2.4 1.7 1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7H65zm16.4 0l1 2.8H86l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h3zm-74 7l.8 2.8h3l-2.4 1.7.9 2.7-2.4-1.7L6 24.2l.9-2.7-2.4-1.7h3zm16.4 0l.9 2.8h2.9l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h2.9zm16.5 0l.9 2.8H45l-2.4 1.7 1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7h2.9zm16.4 0l1 2.8h2.8l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h3zm16.5 0l.9 2.8h2.9l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h2.9zm16.5 0l.9 2.8h2.9L92 21.5l1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7h2.9zm-74.1 7l.9 2.8h2.9l-2.4 1.7 1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7h2.9zm16.4 0l1 2.8h2.8l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h3zm16.5 0l.9 2.8h2.9l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h2.9zm16.5 0l.9 2.8h2.9l-2.4 1.7 1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7H65zm16.4 0l1 2.8H86l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h3zm-74 7l.8 2.8h3l-2.4 1.7.9 2.7-2.4-1.7L6 38.2l.9-2.7-2.4-1.7h3zm16.4 0l.9 2.8h2.9l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h2.9zm16.5 0l.9 2.8H45l-2.4 1.7 1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7h2.9zm16.4 0l1 2.8h2.8l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h3zm16.5 0l.9 2.8h2.9l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h2.9zm16.5 0l.9 2.8h2.9L92 35.5l1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7h2.9zm-74.1 7l.9 2.8h2.9l-2.4 1.7 1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7h2.9zm16.4 0l1 2.8h2.8l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h3zm16.5 0l.9 2.8h2.9l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h2.9zm16.5 0l.9 2.8h2.9l-2.4 1.7 1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7H65zm16.4 0l1 2.8H86l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h3zm-74 7l.8 2.8h3l-2.4 1.7.9 2.7-2.4-1.7L6 52.2l.9-2.7-2.4-1.7h3zm16.4 0l.9 2.8h2.9l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h2.9zm16.5 0l.9 2.8H45l-2.4 1.7 1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7h2.9zm16.4 0l1 2.8h2.8l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h3zm16.5 0l.9 2.8h2.9l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h2.9zm16.5 0l.9 2.8h2.9L92 49.5l1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7h2.9zm-74.1 7l.9 2.8h2.9l-2.4 1.7 1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7h2.9zm16.4 0l1 2.8h2.8l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h3zm16.5 0l.9 2.8h2.9l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h2.9zm16.5 0l.9 2.8h2.9l-2.4 1.7 1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7H65zm16.4 0l1 2.8H86l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h3zm-74 7l.8 2.8h3l-2.4 1.7.9 2.7-2.4-1.7L6 66.2l.9-2.7-2.4-1.7h3zm16.4 0l.9 2.8h2.9l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h2.9zm16.5 0l.9 2.8H45l-2.4 1.7 1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7h2.9zm16.4 0l1 2.8h2.8l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h3zm16.5 0l.9 2.8h2.9l-2.3 1.7.9 2.7-2.4-1.7-2.3 1.7.9-2.7-2.4-1.7h2.9zm16.5 0l.9 2.8h2.9L92 63.5l1 2.7-2.4-1.7-2.4 1.7 1-2.7-2.4-1.7h2.9z" transform="scale(3.9385)"/>
                                    </g>
                                    </svg>              
                                    English (US)
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="block py-2 px-4 text-sm text-gray-700 hover:bg-gray-100 dark:text-gray-300 dark:hover:text-white dark:hover:bg-gray-600" role="menuitem">
                                <div class="inline-flex items-center">
                                    <svg aria-hidden="true" class="h-3.5 w-3.5 rounded-full mr-2" xmlns="http://www.w3.org/2000/svg" id="flag-icon-css-de" viewBox="0 0 512 512">
                                    <path fill="#ffce00" d="M0 341.3h512V512H0z"/>
                                    <path d="M0 0h512v170.7H0z"/>
                                    <path fill="#d00" d="M0 170.7h512v170.6H0z"/>
                                    </svg>
                                    Deutsch
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="block py-2 px-4 text-sm text-gray-700 hover:bg-gray-100 dark:text-gray-300 dark:hover:text-white dark:hover:bg-gray-600" role="menuitem">
                                <div class="inline-flex items-center">
                                    <svg aria-hidden="true" class="h-3.5 w-3.5 rounded-full mr-2" xmlns="http://www.w3.org/2000/svg" id="flag-icon-css-it" viewBox="0 0 512 512">
                                    <g fill-rule="evenodd" stroke-width="1pt">
                                    <path fill="#fff" d="M0 0h512v512H0z"/>
                                    <path fill="#009246" d="M0 0h170.7v512H0z"/>
                                    <path fill="#ce2b37" d="M341.3 0H512v512H341.3z"/>
                                    </g>
                                    </svg>              
                                    Italiano
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="block py-2 px-4 text-sm text-gray-700 hover:bg-gray-100 dark:hover:text-white dark:text-gray-300 dark:hover:bg-gray-600" role="menuitem">
                                <div class="inline-flex items-center">
                                    <svg aria-hidden="true" class="h-3.5 w-3.5 rounded-full mr-2" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" id="flag-icon-css-cn" viewBox="0 0 512 512">
                                    <defs>
                                    <path id="a" fill="#ffde00" d="M1-.3L-.7.8 0-1 .6.8-1-.3z"/>
                                    </defs>
                                    <path fill="#de2910" d="M0 0h512v512H0z"/>
                                    <use width="30" height="20" transform="matrix(76.8 0 0 76.8 128 128)" xlink:href="#a"/>
                                    <use width="30" height="20" transform="rotate(-121 142.6 -47) scale(25.5827)" xlink:href="#a"/>
                                    <use width="30" height="20" transform="rotate(-98.1 198 -82) scale(25.6)" xlink:href="#a"/>
                                    <use width="30" height="20" transform="rotate(-74 272.4 -114) scale(25.6137)" xlink:href="#a"/>
                                    <use width="30" height="20" transform="matrix(16 -19.968 19.968 16 256 230.4)" xlink:href="#a"/>
                                    </svg>
                                    中文 (繁體)
                                </div>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </aside>
                       
                        <div class="m-4 sm:ml-64">
                            <h1 class="m-4 text-2xl font-extrabold tracking-tight text-gray-900 ml-4 md:text-3xl lg:text-6xl dark:text-white">Population Chart</h1>
                            <div id="population-chart"></div>
                            <h1 class="m-4 text-2xl font-extrabold tracking-tight text-gray-900 ml-4 md:text-3xl lg:text-6xl dark:text-white">Gender Chart</h1>
                            <div id="gender-chart"></div>
                            <h1 class="m-4 text-2xl font-extrabold tracking-tight text-gray-900 ml-4 md:text-3xl lg:text-6xl dark:text-white">Age Chart</h1>
                            <div id="age-chart"></div>
                            <h1 class="m-4 text-2xl font-extrabold tracking-tight text-gray-900 ml-4 md:text-3xl lg:text-6xl dark:text-white">Fees Chart</h1>
                            <div id="fees-chart"></div>
                            <h1 class="m-4 text-2xl font-extrabold tracking-tight text-gray-900 ml-4 md:text-3xl lg:text-6xl dark:text-white">Location Chart</h1>
                            <div id="location-chart"></div>
                            <h1 class="m-4 text-2xl font-extrabold tracking-tight text-gray-900 ml-4 md:text-3xl lg:text-6xl dark:text-white">Nation Chart</h1>
                            <div id="nation-chart"></div>
                            <h1 class="m-4 text-2xl font-extrabold tracking-tight text-gray-900 ml-4 md:text-3xl lg:text-6xl dark:text-white">Height Chart</h1>
                            <div id="height-chart"></div>
                            <h1 class="m-4 text-2xl font-extrabold tracking-tight text-gray-900 ml-4 md:text-3xl lg:text-6xl dark:text-white">Weight Chart</h1>
                            <div id="weight-chart"></div>
                            <h1 class="m-4 text-2xl font-extrabold tracking-tight text-gray-900 ml-4 md:text-3xl lg:text-6xl dark:text-white">Rating Chart</h1>
                            <div id="rating-chart"></div>
                        </div>
                        
                        
                        
                        
                        
                        
                                                        <script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
                        <script>

getPopulation = () => {
    return {
  chart: {
    type: 'bar'
  },
  plotOptions: {
    bar: {
      distributed: true
    }
  },
  series: [{
    data: [{
      x: "Staff",
      y: <%= staffs.size() %>
    }, {
      x: "Trainer",
      y: <%= trainers.size() %>
    }, {
      x: "Customer",
      y: <%= customers.size() %>
    }]
  }]
};};
getGender = () => {
    return {
  chart: {
      height: 350,
      type: "treemap",
    },
      plotOptions: {
    treemap: {
      distributed: true
    }
  },
    series: [
      {
        data: [
          {
            x: "Male",
            y: <%= male %>
          },
          {
            x: "Female",
            y: <%= female %>
          }
        ]
      }
    ]
};};
getAge = () => {
    return {
      chart: {
      type: "pie"
    },
    series: <%= agevalues %>,
    labels: <%= agekeys %>
  };};
getFees = () => {
    return {
      chart: {
      type: "donut"
    },
    series: <%= gymFeesvalues %>,
    labels: <%= gymFeeskeysJson %>
  };};
getLocation = () => {
    return {
      chart: {
      type: "pie"
    },
    series: <%= locationvalues %>,
    labels: <%= locationkeysJson %>
  };};
getNation = () => {
    return {
      chart: {
      type: "donut"
    },
    series: <%= nationvalues %>,
    labels: <%= nationkeysJson %>
  };};
getHeight = () => {
    return {
      chart: {
      type: "pie"
    },
    series: <%= heightvalues %>,
    labels: <%= heightkeys %>
  };};
getWeight = () => {
    return {
      chart: {
      type: "donut"
    },
    series: <%= weightvalues %>,
    labels: <%= weightkeys %>
  };};
  
  getRating = () => {
    return {
      chart: {
      type: "pie"
    },
    series: <%= ratingvalues %>,
    labels: <%= ratingkeys %>
  };};

if (document.getElementById('population-chart')) {
	const chart = new ApexCharts(document.getElementById('population-chart'), getPopulation());
	chart.render();
};
if (document.getElementById('gender-chart')) {
	const chart = new ApexCharts(document.getElementById('gender-chart'), getGender());
	chart.render();
};
if (document.getElementById('age-chart')) {
	const chart = new ApexCharts(document.getElementById('age-chart'), getAge());
	chart.render();
};
if (document.getElementById('fees-chart')) {
	const chart = new ApexCharts(document.getElementById('fees-chart'), getFees());
	chart.render();
};
if (document.getElementById('location-chart')) {
	const chart = new ApexCharts(document.getElementById('location-chart'), getLocation());
	chart.render();
};
if (document.getElementById('nation-chart')) {
	const chart = new ApexCharts(document.getElementById('nation-chart'), getNation());
	chart.render();
};
if (document.getElementById('height-chart')) {
	const chart = new ApexCharts(document.getElementById('height-chart'), getHeight());
	chart.render();
};
if (document.getElementById('weight-chart')) {
	const chart = new ApexCharts(document.getElementById('weight-chart'), getWeight());
	chart.render();
};
if (document.getElementById('rating-chart')) {
	const chart = new ApexCharts(document.getElementById('rating-chart'), getRating());
	chart.render();
};
                           </script>
                                <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.js"></script>

    </body>
</html>
