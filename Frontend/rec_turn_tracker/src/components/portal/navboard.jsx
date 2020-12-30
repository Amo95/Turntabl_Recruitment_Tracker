import React from "react";
import { connect } from 'react-redux'
import { Link, Redirect } from 'react-router-dom'



export class Navboard extends React.Component {
    state = {}

    onSubmitHandler = () => {
        localStorage.clear();
        return <Redirect to="/" />
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
            <a id="dashboard">
            <div>

            <nav>
                <div className="logo">
                    <h4></h4>
                </div>

                <ul className="nav-links" /*onClick = {this.navSlide} */ > 
                    <li>
                        <a href="#dashboard"> <i class="fa fa-home"></i>&nbsp; Home </a>
                    </li>

                    <li>
                        <a href="#"> <i className="fa fa-user"></i>&nbsp; Profile</a>
                    </li>

                    <li>
                        <a href="#myform"> <i className="fa fa-address-card"></i>&nbsp; Applicant Form </a>
                    </li>
                    
                    <li> 
                        <a href="#"> <i class="fa fa-money"></i>&nbsp; Bank Details </a>
                    </li>

                    <li>
                        <button><i class="fa fa-sign-out"></i> &nbsp; Logout</button>
                    </li>
                    

                </ul>

                <button className="buggerLines" onClick = {this.navSlide}>
                    <div className="line1"></div>
                    <div className="line2"></div>
                    <div className="line3"></div>
                </button> 
            </nav>
            
        </div>
        </a>


        );
    }


}

export default connect()(Navboard);