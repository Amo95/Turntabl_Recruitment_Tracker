import React, { Component } from 'react';
import Aos from 'aos';
import "aos/dist/aos.css"
import "./style/dash.css"
import "bootstrap/dist/css/bootstrap.css"
import "bootstrap/dist/js/bootstrap.js"
import { Footer } from './footer';
import { Redirect, Link } from "react-router-dom"
class LandingPage extends Component {
    componentDidMount() {
        Aos.init({ duration: 2000 })
    }
    onSubmitHandler = () => {
        localStorage.clear();
        return <Redirect to="/togle" />
    }
    state = {}
    render() {
        return (<>
            <div className="main-container">
                <div className="hearder">
                    <div className="brand"><h2>TURNTABL | GH</h2></div>
                    <div id="navbar">
                        <a href="#contact">Contact</a>
                        <a href="#news">About</a>
                        <a href="#home">Home</a>
                    </div>
                </div>

                <div className="hero-image">
                    <div className="hero-text">
                        <h1 data-aos="fade-left">Welcome to turntabl Ghana</h1>
                        <p data-aos="fade-right">You can click on the apply button to apply for a job</p>
                        <Link to="/togle">
                            <button> Apply now</button>
                        </Link>

                    </div>
                </div>
                <div className="arrow">
                    <img src="/images/double-arrow-down.png" width="40" />
                </div>
            </div>
            <div className="who">
                <p className="header-banner">Who are we ?</p>
            </div>

            <div data-aos="flip-left" className="container pb-3">

                <div className="row">
                    <div className="col-md-4">
                        <div data-aos="fade-up" className="card">
                            <div className="card">
                                <div className="card-image">
                                    <img src="/images/expert.png" width="100%" height="50% " />
                                </div>
                                <div className="who">
                                    <h5>Expertise</h5>
                                    <p>The turntabl learning program is legendary. All our developers pass through two months of tuition, group work and practical exercises.</p>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div className="col-md-4">
                        <div data-aos="fade-up" className="card">
                            <div data-aos="fade-up" className="card">
                                <div className="card">
                                    <div className="card-image">
                                        <img src="/images/excell.png" alt="" width="100%" />
                                    </div>
                                    <div className="who">
                                        <h5>Excellence</h5>
                                        <p>
                                            Communication is key. Everyone in our team is an excellent communicator: a native English speaker with fantastic technical literacy.
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-4">
                        <div data-aos="fade-left" className="card">
                            <div data-aos="fade-up" className="card">
                                <div className="card">
                                    <div className="card-image">
                                        <img src="/images/expi.png" width="100%" />
                                    </div>
                                    <div className="who">
                                        <h5>Experience</h5>
                                        <p>
                                            We've been in the trenches. turntabl teams are led by experts. Agile development, program management, incident response: you can trust us.
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <Footer />
        </>);
    }
}



export default LandingPage;