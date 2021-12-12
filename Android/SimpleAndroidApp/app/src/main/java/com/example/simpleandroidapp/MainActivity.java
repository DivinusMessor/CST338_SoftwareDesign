package com.example.simpleandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listview);

        ArrayList<String> arrayList=new ArrayList<>();

        arrayList.add("CST 300: Major ProSeminar"); //0
        arrayList.add("CST 338: Software Design"); //1
        arrayList.add("CST 363: Database Management"); //2
        arrayList.add("CST 334: Operating Systems"); //3
        arrayList.add("CST 311: Introduction to Computer Networking"); //4
        arrayList.add("CST 336: Internet Programming"); //5
        arrayList.add("CST 462S: Race, Gender, Class in the Digital World"); //6
        arrayList.add("CST 370: Algorithms"); //7
        arrayList.add("CST 383: Introduction to Data Science"); //8
        arrayList.add("CST 438: Software Engineering"); //9
        arrayList.add("CST 489: Capstone Project Planning"); //10
        arrayList.add("CST 499: Directed Group Capstone"); //11

        ArrayAdapter arrayAdapter=new ArrayAdapter(
                this, android.R.layout.simple_list_item_1, arrayList);


        listView.setAdapter(arrayAdapter);

        // Adding the listener functions
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this, "clicked item: " + i + " " + arrayList.get(i).toString(), Toast.LENGTH_LONG).show();
                // CST 300: Major ProSeminar
                if (i == 0){
                    Toast.makeText(MainActivity.this, "Helps students identify and articulate personal, professional, " +
                            "and social goals. Provides an integrated overview of the computer science and communication design " +
                            "majors and their requirements. Students develop a plan for their learning goals. Students learn writing, " +
                            "presentation, research and critical-thinking skills within the diversified fields of information technology " +
                            "and communication design. Students learn how to analyze, predict, and articulate trends in the academic, " +
                            "public service,", Toast.LENGTH_LONG).show();
                }
                // CST 338: Software Design
                if (i == 1){
                    Toast.makeText(MainActivity.this, "Provides students with the fundamental concepts to develop large-scale software, " +
                            "focusing on the object-oriented programming techniques. Coverage includes the introduction to Java programming language, " +
                            "object-oriented programming, software life cycle and development processes, requirements analysis, and graphical " +
                            "user interface development.", Toast.LENGTH_LONG).show();
                }
                // CST 363: Database Management
                if (i == 2){
                    Toast.makeText(MainActivity.this, "This course provides balanced coverage of database use and design,focusing " +
                            "on relational databases. Students will learn to design relational schemas, write SQL queries, access a DB " +
                            "programmatically,and perform database administration. Students will gain a working knowledge of the algorithms " +
                            "and data structures used in query evaluation and transaction processing. Students will also learn to apply " +
                            "newer database technologies such as XML, NoSQL, and Hadoop.", Toast.LENGTH_LONG).show();
                }
                // CST 334: Operating Systems
                if (i == 3){
                    Toast.makeText(MainActivity.this, "Students in this course will learn about the use and design of " +
                            "modern operating systems, focusing on Linux. On the “use” side, students will learn the Linux command line, " +
                            "to write shell scripts, and to build programs with GNU utilities like awk, sed, and make. On the “design” side, " +
                            "students will develop a deep understanding of process management, memory management, file systems, and " +
                            "concurrency, and how they apply to modern technologies like virtualization and cloud computing.", Toast.LENGTH_LONG).show();
                }
                // CST 311: Introduction to Computer Networking
                if (i == 4){
                    Toast.makeText(MainActivity.this, "Survey of Telecomm and Data Comm Technology Fundamentals, Local Area Network, " +
                            "Wide Area Network, Internet and internetworking protocols including TCP/IP, network security and performance, " +
                            "emerging industry trends such as voice over the network and high speed networking. Designed as a foundation for " +
                            "students who wish to pursue more advanced network studies including certificate programs. Includes hands-on " +
                            "networking labs that incorporate Cisco CCNA lab components.", Toast.LENGTH_LONG).show();
                }
                // CST 336: Internet Programming
                if (i == 5){
                    Toast.makeText(MainActivity.this, "Provides students with dynamic web application development skills, focusing " +
                            "on the integration of server-side programming, database connectivity, and client-side scripting. Coverage includes " +
                            "the Internet architecture, responsive design, RESTful web services, and Web APIs. ", Toast.LENGTH_LONG).show();
                }
                // CST 462S: Race, Gender, Class in the Digital World
                if (i == 6){
                    Toast.makeText(MainActivity.this, "Provides students with key knowledge of race, gender, " +
                            "class and social justice especially in relation to technology in today’s digital world. Students challenge " +
                            "the barriers of expertise, gender, race, class, and location that restrict wider access to and understanding of " +
                            "the production and usage of new technologies. Students will engage in a practical experience in the community " +
                            "via their service placements, which will provide depth and context for considering questions of justice, equality, " +
                            "social responsibilities and the complexities of technology and its societal impact. The course uses scenario based " +
                            "approach combining presentations, discussions, and reflections to allow students explore the relationship between " +
                            "critical reflection and action on the topics mentioned above. ", Toast.LENGTH_LONG).show();
                }
                // CST 370: Algorithms
                if (i == 7){
                    Toast.makeText(MainActivity.this, "Students learn important data structures in computer science and acquire " +
                            "fundamental algorithm design techniques to get the efficient solutions to several computing problems from various " +
                            "disciplines. Topics include the analysis of algorithm efficiency, hash, heap, graph, tree, sorting and searching, " +
                            "brute force, divide-and-conquer, decrease-and-conquer, transform-and-conquer, dynamic programming, and greedy " +
                            "programming.", Toast.LENGTH_LONG).show();
                }
                // CST 383: Introduction to Data Science
                if (i == 8){
                    Toast.makeText(MainActivity.this, "In data science, data analysis and machine learning techniques are applied " +
                            "to visualize data, understand trends, and make predictions. In this course students will learn how to obtain data, " +
                            "preprocess it, apply machine learning methods, and visualize the results. A student who completes the course will " +
                            "have enough theoretical knowledge, and enough skill with modern statistical programming languages and their libraries," +
                            "to define and perform complete data science projects.", Toast.LENGTH_LONG).show();
                }
                // CST 438: Software Engineering
                if (i == 9){
                    Toast.makeText(MainActivity.this, "Prepares students for large-scale software development using software " +
                            "engineering principles and techniques. Coverage includes software process, requirements analysis and specification, " +
                            "software design, implementation, testing, and project management. Students are expected to work in teams to carry " +
                            "out a realistic software project.", Toast.LENGTH_LONG).show();
                }
                // There is no description to the class on the website
                // CST 489: Capstone Project Planning
                if (i == 10){
                    Toast.makeText(MainActivity.this, "Capstone Project Planning", Toast.LENGTH_LONG).show();
                }
                // CST 499: Directed Group Capstone
                if (i == 11){
                    Toast.makeText(MainActivity.this, "Students will work on a project in large groups (up to 5 students in each group), " +
                            "developing requirements specification, a solution plan followed by design and implementation of the solution. The problem " +
                            "statement for the projects will be selected by the faculty. Faculty will also play the role of a project manager directing " +
                            "the schedule and deliverables for these projects.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void browser1 (View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"));
        startActivity(browserIntent);
    }
}