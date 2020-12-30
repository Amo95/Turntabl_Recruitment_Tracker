import React from "react";
// import AppJs from "./app";
import { connect } from 'react-redux'
import { Redirect } from 'react-router-dom'

import Applicant from "../applicant/applicantFormv2";
import Introduction from "./introduction";
import Footer from "./footer";


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