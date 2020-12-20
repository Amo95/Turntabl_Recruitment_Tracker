import React from "react";
import { connect } from 'react-redux'


export class Footer extends React.Component {
    constructor(props) {
        super(props)
    }


    render() {
        return (
            <div>
                <div className="footer">
                    <div className="footer-content">
                        <div className="footer-section about">
                            <h2 className="logo-text"> <span>TURN</span>TABL</h2>
                            <p>
                            As an IT services company, we’re absolutely dependent on an internet connection.
                            In these posts we’re hoping to give brief updates as to what we’re doing and what 
                            progress we’re making.
                            </p>
                            <div className="contact">
                                <span><i className="fa fa-envelope"></i> <a href="mailto:info@turntabl.io">Send Feedback </a> </span>
                            </div>
                            <div className="socials">
                                <a href="https://twitter.com/turntablio" target="_blank" rel="noopener noreferrer"><i className="fa fa-twitter">&nbsp; Twitter</i></a>
                                <a href="https://github.com/turntabl" target="_blank" rel="noopener noreferrer"><i className="fa fa-github">&nbsp; GitHub</i></a>
                            </div>
                        </div>
                        <div className="footer-section links">
                            <h2>Quick Links</h2>
                            <br/>
                            <ul>
                                <a href="https://turntabl.io/blog" target="_blank" rel="noopener noreferrer"><li> Our Blog</li></a>
                                <a href="https://turntabl.io/aims" target="_blank" rel="noopener noreferrer"><li> Our Aims</li></a>
                                <a href="https://turntabl.io/job" target="_blank" rel="noopener noreferrer"><li>Apply for other Jobs at Turntabl</li></a>
                            </ul>
                        </div>
                        <div className="footer-section location">
                            <h2>Location</h2>
                                <a href="https://goo.gl/maps/stg8k2UfxUqz39YM9" target="_blank" rel="noopener noreferrer"><li> turntabl GH Ltd, 2nd floor, Sonnidom House, Achimota, Mile 7, Accra</li></a>
                                <a href="https://goo.gl/maps/Kvix7ipaD4FNuVc2A" target="_blank" rel="noopener noreferrer"><li> Opposite NARPO Hotel</li></a>
                                <a href="https://goo.gl/maps/2Bei8myvgdVsTr3SA" target="_blank" rel="noopener noreferrer"><li> Same block with APSA Bank</li></a>
                                <a href="https://goo.gl/maps/ekx72spukmuLQd5s5" target="_blank" rel="noopener noreferrer"><li> Opposite Miile 7, Police station</li></a>
                        </div>
                    </div>

                    <div className="footer-bottom">
                        &copy; turntabl.io | Design by "Group of Eight" &nbsp; &nbsp; &nbsp; &nbsp; 
                        Made with <i className="fa fa-heart"></i> by <a href="https://turntabl.io/">Turntabl</a> in Ghana. 

                    </div>
                </div>
            </div>
        );
    }
}

export default connect()(Footer);