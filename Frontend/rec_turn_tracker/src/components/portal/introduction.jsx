import React from "react";
import { connect } from 'react-redux'
// import parallaxImg1 from "../../";

export class Introduction extends React.Component {

    constructor (props) {
        super(props);
    }



    render () {
        return (
            <a id="#introduction">
            <div  className="body">

                <div className="pimg2">
                    <div className="ptext">
                        <span className="border trans">
                            Welcome To Turntabl Recruitement Page
                        </span>
                    </div>
                </div>
                <section className="section section-dark">
                    <h2>Why work with Turntabl?</h2>
                    <p>
                    Turntabl is a technical partner that combines decades of Fortune 500 technology 
                        and training experience with a track record in Ghana. We provide highly motivated 
                        engineers managed by staff seasoned in western companies.
                       Engineers will become available in January 2020: now is a great time to start working 
                       with turntabl to create value for money technology sourcing for your company.
                       <b>Guest Post: Doreen</b>
                        
                    </p>
                </section>

                <div className="pimg3">
                    <div className="ptext">
                        <span className="border trans">
                            THE ENTERPRICE
                        </span>
                    </div>
                </div>
                <section className="section section-dark">
                    <h2>Turntabl - A Sustainable Enterprise</h2>
                    <p>
                    We’re setting up Turntabl to make a difference in Ghana. It is our aim to develop 
                    a sustainable enterprise with a quality focus and a global outlook. We aim for 
                    Turntabl to provide all the employees, including ourselves, with a good wage. 
                    At the same time we want to make as much positive change as possible. Ultimately we 
                    intend to part with the company, giving it away so that its wealth creation can 
                    benefit Ghana to the fullest. <b>Guest Post: Christiana</b>
                    </p>
                </section>

                <div className="pimg4">
                    <div className="ptext">
                        <span className="border trans">
                            GHANA AS A PLACE FOR BUSINESS
                        </span>
                    </div>
                </div>
                <section className="section section-dark">
                    <h2>Ghana is emerging as a great place to do business</h2>
                    <p>
                    There is a compelling business case for Western companies to benefit from the 
                    opportunities that can currently be found in Ghana. It is a stable multi-party 
                    democracy which has seen successive peaceful transitions of power. Accra, the capital 
                    city, is safe and accessible, with modern internet and office facilities. Corruption is 
                    the lowest in the region – lower than some large European states. Situated in West Africa close 
                    to the Greenwich meridian, Ghana spends half the year in the same time zone as the United Kingdom 
                    and the other half on Central European Time. Your turntabl colleagues can work closely and 
                    effectively with staff in London and the rest of Europe. As the official language, 
                    English is spoken widely and fluently – higher education is conducted in English. 
                    Generally, levels of spoken English and comprehension are higher than other popular 
                    technology locations such as India, China and Mexico.Turntabl’s unique blend of 
                    proven expertise from Western companies and local knowledge will deliver the cost 
                    and capability benefits of Ghana to your business on a sound ethical basis that we 
                    can all be proud to participate in. Read more about the ethical aspect of our work 
                    in Ghana here. <b>Unknown</b>
                    </p>
                </section>

                <div className="pimg1">
                    <div className="ptext">
                        <span className="border">
                            AFRICA
                        </span>
                    </div>
                </div> 
                <section className="section section-light">
                    <h2>Africa is not a country (again)</h2>
                    <p>
                        TWe are not the first to comment on the lazy habit of some of those in the West 
                        who accidentally view Africa as a single country. Prominent politicians and 
                        other public figures have been called out for this slip of the tongue, and many 
                        media articles have described the damage that this mindset causes.
                    </p>
                </section>

                <div className="pimg5">
                    <div className="ptext">
                        <span className="border trans">
                            Are You Software Engineer?, Fill Out Applicant Form
                            
                        </span>
                    </div>
                </div>

            </div>
            </a>

        );
    }
}

export default connect() (Introduction);