import React from "react";

import { connect } from 'react-redux'
import { Redirect } from 'react-router-dom'

import { connect } from 'react-redux';

import Applicant from "../applicant/applicantFormv2";
import Footer from "./footer";
import Navboard from "./navboard";
import Profile from "./profile";
import Bank from "./bank";
import Tracker from "./tracker"

export class Dashboard extends React.Component {
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


=======
    state = { 
        panel:()=> <Profile /> 
     }

     profile = ()=> this.setState({panel: () => <Profile />});
     tracker = ()=> this.setState({panel: () => <Tracker />});
     bank = ()=> this.setState({panel: () => <Bank />});
     apply = ()=> this.setState({panel: () => <Applicant />})
    

    render () {
        return (
           
            <div className="dash">
                <div className="wrapper">
                    <div className="sidebar">
                        <h2><a href="#"><span>turn</span>tabl</a></h2>
                        <ul className="line">
                            <li className="liner">
                                <a onClick={this.profile} href="#"><i className="fa fa-user"></i>&nbsp; Profile</a>
                            </li>
                            <li className="liner">
                                <a onClick={this.apply} href="#"><i className="fa fa-address-card"></i>&nbsp; Applicant Form </a>
                            </li>
                            <li className="liner">
                                <a onClick={this.bank} href="#"><i class="fa fa-money"></i>&nbsp; Bank Details</a>
                            </li>
                            <li className="liner">
                                <a onClick={this.tracker} href="#"><i className="fa fa-map-pin"></i>&nbsp; Tracker</a>
                            </li>
                            <li className="liner">
                                <button><i class="fa fa-sign-out"></i> Logout</button>
                            </li>
                        </ul>
                    </div>
                    <div className="main_content">
                        <div className="header"> <Navboard /> </div>   
                        <div className="info">
                        {this.state.panel() }
                        <Footer />
                    </div>
                    </div>
                </div>
            </div>


        );
    }

    render() {
        if (localStorage.getItem("id") === null) {
            return <Redirect to={{ pathname: "/" }} />
        } else {
            return (
                <a id="dashboard">
                    <div>

                        <nav>
                            <div className="logo">
                                <h4><span>turn</span>tabl</h4>
                            </div>

                            <ul className="nav-links">
                                <li>
                                    <a href="#dashboard"> Home </a>
                                </li>

                                <li>
                                    <a href="#myform"> Applicant Form </a>
                                </li>

                                <li>
                                    <a href="#"> Details </a>
                                </li>

                                <li>
                                    <p>Hello Jane Doe</p>
                                </li>

                                <li>
                                    <form><button onClick={this.onSubmitHandler}>Logout</button></form>
                                </li>


                            </ul>

                            <button className="buggerLines" onClick={this.navSlide}>
                                <div className="line1"></div>
                                <div className="line2"></div>
                                <div className="line3"></div>
                            </button>
                        </nav>

                        <div id="intro">
                            <Introduction />
                        </div>

                        <div id="form" className="fallback">
                            <Applicant />
                        </div>
                        <div>
                            <Footer />
                        </div>

                    </div>
                </a>


            );
        }

    }
}

export default connect()(Dashboard);