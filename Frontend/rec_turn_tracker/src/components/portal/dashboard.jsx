import React from "react";
// import AppJs from "./app";

export class Dashboard extends React.Component {
    constructor(props) {
        super(props);
    }

    navSlide = () => {
        const buggerLines = document.querySelector('.buggerLines');
        const nav = document.querySelector('.nav-links');
        const navLinks = document.querySelectorAll('.nav-links li')

        buggerLines.addEventListener('click', () => {
            // toggle nav in reponsive mood
        nav.classList.toggle('nav-active');

            // animate links
        navLinks.forEach((link, dashboard) => {
            if (link.style.animation) {
               link.style.animation = ''
            }
            else {
                link.style.animation = `navLinkFade 05s ease forwards ${dashboard / 4 + 1.5}s`;
            }
                
        });

            // bugger Animation
        buggerLines.classList.toggle('toggle');
        });

        
    }

    render () {
        return (

            <nav>
                <div className="logo">
                    <h4>turntabl</h4>
                </div>

                <ul className="nav-links" onClick = {this.navSlide}>
                    <li> 
                        <p>Hello Jane Doe</p>
                    </li>

                    <li className="turnOff">
                        <p>||</p>
                    </li>

                    <li>
                        <a href="#"> Applicant Form </a>
                    </li>

                    <li className="turnOff">
                        <p>|</p>
                    </li>

                    <li>
                        <a href="#"> Tracker </a>
                    </li>

                    <li className="turnOff">
                        <p>|</p>
                    </li>

                    <li>
                        <a href="#"> Logout</a>
                    </li>
                    

                </ul>
                <button className="buggerLines" onClick = {this.navSlide}>
                    <div className="line1"></div>
                    <div className="line2"></div>
                    <div className="line3"></div>
                </button> 
            </nav>
        );
    }


}


export default Dashboard;