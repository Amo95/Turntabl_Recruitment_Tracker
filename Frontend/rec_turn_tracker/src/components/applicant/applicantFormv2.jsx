
import React from "react";
import ReactWizard from "react-bootstrap-wizard";
import './appv2.css'
import {
  Container,
  Row,
  Col,
  FormGroup,
  Input,
  Label
} from "reactstrap";
import "./applyv2.css"

import { Redirect } from 'react-router-dom';

import "bootstrap/dist/css/bootstrap.css";
import SimpleReactValidator from 'simple-react-validator';

import PhoneInput from 'react-phone-input-2'
import 'react-phone-input-2/lib/style.css'
import Header from "./header";

// First component
class FirstStep extends React.Component {
  constructor(props) {

    super(props);
    this.state = {
      first_name: "",
      middle_name: "",
      last_name: "",
      nick_name: "",
      date_of_birth: "",
      gender: "",
    };
  }

  validator = new SimpleReactValidator();

  onChangeHandler = (event) => {
    let name = event.target.name;
    let value = event.target.value;
    this.setState({ [name]: value })
  }

  submitForm() {
    if (this.validator.allValid()) {
      alert('You submitted the form and stuff!');
    } else {
      this.validator.showMessages();

      this.forceUpdate();
    }
  }

  render() {
    const { first_name, middle_name, last_name, nick_name, date_of_birth, gender } = this.state;
    return <Container>
      <Row>

        <Col xs={12} md={6} className="mr-auto ml-auto">
          <FormGroup>
            <Label for="first_name">First Name</Label>
            <Input type="text" name="first_name" id="first_name" placeholder="Enter first name" value={first_name} onChange={this.onChangeHandler} />
            {this.validator.message('first_name', first_name, 'required|alpha')}
          </FormGroup>
        </Col>

        <Col xs={12} md={6} className="mr-auto ml-auto">
          <FormGroup>
            <Label for="middle_name">Middle Name</Label>
            <Input type="text" name="middle_name" id="middle_name" placeholder="Enter middle name" value={middle_name} onChange={this.onChangeHandler} />
          </FormGroup>
        </Col>
        <Col xs={12} md={6} className="mr-auto ml-auto">
          <FormGroup>
            <Label for="last_name">Last Name</Label>
            <Input type="text" name="last_name" id="last_name" placeholder="Enter last name" value={last_name} onChange={this.onChangeHandler} />
          </FormGroup>
        </Col>
        <Col xs={12} md={6} className="mr-auto ml-auto">
          <FormGroup>
            <Label for="nick_name">Nick Name</Label>
            <Input type="text" name="nick_name" id="nick_name" placeholder="Enter nick name" value={nick_name} onChange={this.onChangeHandler} />
          </FormGroup>
        </Col>

        <Col xs={12} md={6} className="mr-auto ml-auto">
          <FormGroup>
            <Label for="last_name">Date of Birth</Label>
            <Input type="date" name="date_of_birth" id="date_of_birth" value={date_of_birth} onChange={this.onChangeHandler} />
          </FormGroup>
        </Col>
        <Col xs={12} md={6} className="mr-auto ml-auto">
          <FormGroup>
            <Label for="exampleSelectMulti">Select Gender</Label>
            <Input type="select" name="gender" id="exampleSelectMulti" value={gender} onChange={this.onChangeHandler}>
              <option>--Select Gender--</option>
              <option>Male</option>
              <option>Female</option>
            </Input>
          </FormGroup>
        </Col>

      </Row>
    </Container>;
  }
}
// =====================end of first component==================




// =================Second component=========================
class SecondStep extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      address1: "",
      address2: "",
      city: "",
      region: "",
      zip_code: "",
      phone_number: "",
      phone_number2: ""
    };
  }

  onChangeHandler = (event) => {
    let name = event.target.name;
    let value = event.target.value;
    this.setState({ [name]: value })
  }

  onChangeHandlerPh1 = (value) => {
    this.setState({ phone_number: value })
  }

  onChangeHandlerPh2 = (value) => {
    this.setState({ phone_number2: value })
  }

  isValidated() {
    // do some validations
    // decide if you will
    return true;
    // or you will
    // return false;
  }
  render() {
    const { address1, address2, city, region, zip_code } = this.state;
    return <Container>
      <Row>
        <Col xs={12} md={6} className="mr-auto ml-auto">
          <FormGroup>
            <Label for="address1">Street Address Line 1</Label>
            <Input type="text" name="address1" id="address1" placeholder="Street Address Line 1" value={address1} onChange={this.onChangeHandler} />
          </FormGroup>
        </Col>

        <Col xs={12} md={6} className="mr-auto ml-auto">
          <FormGroup>
            <Label for="address2">Street Address Line 2</Label>
            <Input type="text" name="address2" id="address12" placeholder="Street Address Line 2" value={address2} onChange={this.onChangeHandler} />
          </FormGroup>
        </Col>


        <Col xs={12} md={4} className="mr-auto ml-auto">
          <FormGroup>
            <Label for="city">City</Label>
            <Input type="text" name="city" id="city" placeholder=" Enter city" value={city} onChange={this.onChangeHandler} />
          </FormGroup>
        </Col>

        <Col xs={12} md={4} className="mr-auto ml-auto">
          <FormGroup>
            <Label for="address2">Region</Label>
            <Input type="text" name="region" id="region" placeholder=" Enter region" value={region} onChange={this.onChangeHandler} />
          </FormGroup>
        </Col>

        <Col xs={12} md={4} className="mr-auto ml-auto">
          <FormGroup>
            <Label for="zip_code">Zip Code</Label>
            <Input type="text" name="zip_code" id="zip_code" placeholder=" Enter zip code" value={zip_code} onChange={this.onChangeHandler} />
          </FormGroup>
        </Col>

        <Col xs={12} md={6} className="mr-auto ml-auto">
          <FormGroup>
            <Label for="phone_number">Phone Number</Label>
            <PhoneInput country='gh' inputStyle={{ width: "100%" }} onChange={this.onChangeHandlerPh1} />
          </FormGroup>
        </Col>

        <Col xs={12} md={6} className="ml-auto mr-auto">
          <FormGroup>
            <Label for="phone_number2">WhatsApp Number</Label>
            <PhoneInput country='gh' inputStyle={{ width: "100%" }} onChange={this.onChangeHandlerPh1} />
          </FormGroup>
        </Col>
      </Row>
    </Container>
  }
}
// ===============End of secon component==========================


// ===========Third component================================
class ThirdStep extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      university: "",
      year_graduated: "",
      nss_number: "",
      snnit_number: "",
      nss_status: () => <></>,
      ssnit_status: () => <></>
    };
  }


  onChangeHandler = (event) => {
    let name = event.target.name;
    let value = event.target.value;
    this.setState({ [name]: value })
  }

  nss_statusHandler = (event) => {
    let checked = event.target.checked;

    if (checked) {
      this.setState({
        nss_status: () =>
          <FormGroup>
            <hr />
            <Input type="text" name="nss_number" placeholder="Enter NSS number" value={this.state.nss_number} onChange={this.onChangeHandler} />
          </FormGroup>
      })
    }
    else { this.setState({ nss_status: () => <></> }) }
  }

  ssnit_statusHandler = (event) => {
    let checked = event.target.checked;

    if (checked) {
      this.setState({
        ssnit_status: () =>
          <FormGroup>
            <hr />
            <Input type="text" name="ssnit_number" placeholder="Enter SSNIT number" value={this.state.snnit_number} onChange={this.onChangeHandler} />
          </FormGroup>
      })
    }
    else { this.setState({ ssnit_status: () => <></> }) }
  }


  render() {
    return <Container>
      <Row>
        <Col xs={12} md={6} className="mr-auto ml-auto">
          <FormGroup>
            <Label for="university">University Name</Label>
            <Input type="text" name="university" id="university" placeholder="Enter university name" value={this.state.university} onChange={this.onChangeHandler} />
          </FormGroup>
        </Col>

        <Col xs={12} md={6} className="mr-auto ml-auto">
          <FormGroup>
            <Label for="year_graduated">Year Graduated</Label>
            <Input type="date" name="year_graduated" id="year_graduated" value={this.state.year_graduated} onChange={this.onChangeHandler} />
          </FormGroup>
        </Col>

        <Col xs={12} md={6} className="mr-auto ml-auto">
          <FormGroup check>
            <Label check>
              <Input type="checkbox" onClick={this.nss_statusHandler} />{' '}
              Are you doing NSS?
            </Label>
          </FormGroup>
          {this.state.nss_status()}
        </Col>

        <Col xs={12} md={6} className="mr-auto ml-auto">
          <FormGroup check>
            <Label check>
              <Input type="checkbox" onClick={this.ssnit_statusHandler} />{' '}
              Do you have SSNIT number?
            </Label>
          </FormGroup>
          {this.state.ssnit_status()}
        </Col>
      </Row>
    </Container>;
  }
}
// ====================end of third component================


// ====================Fourth component====================
class FourthStep extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      recommender: ""
    };
  }

  onChangeHandler = (event) => {
    let name = event.target.name;
    let value = event.target.value;
    this.setState({ [name]: value })
  }
  render() {
    return <Container>
      <Row>
        <Col xs={12} md={6} className="mr-auto ml-auto">
          <FormGroup>
            <Label for="recommender">Referral fullname</Label>
            <Input type="text" name="recommender" id="recommender" placeholder="Enter referral fullname" value={this.state.recommender} onChange={this.onChangeHandler} />
          </FormGroup>
        </Col>

        <Col xs={12} md={6} className="mr-auto ml-auto" >
          <br />
          <Input type="file" name="file" id="exampleFile" />
        </Col>
      </Row>
    </Container>;
  }
}

var steps = [
  // this step hasn't got a isValidated() function, so it will be considered to be true

  {
    stepName: "Personal Information",
    component: FirstStep
  },
  // this step will be validated to false
  {
    stepName: "Address & Contact",
    component: SecondStep
  },
  // this step will never be reachable because of the seconds isValidated() steps function that will always return false
  {
    stepName: "Employment & University info",
    component: ThirdStep
  },
  {
    stepName: "CV & Recommendation",
    component: FourthStep
  }
];

class Applicant extends React.Component {
  finishButtonClick(allStates) {
    console.log(allStates);
  }
  render() {
    return (
      <div className="contain">
        <Header />
        <Container fluid >
          <Row>
            <Col xs={12} md={10} className="mr-auto ml-auto">
              <ReactWizard
                steps={steps}
                title="TURNTABL APPLICANT FORM"
                headerTextCenter
                validate
                finishButtonClick={this.finishButtonClick}
              />
            </Col>
          </Row>
        </Container>
        <div className="mt-3 footer-v2">
          <div className="row text-light">
            <div className="col-md-4"></div>
            <div className="col-md-6">
              <p>Made with <i className="fa fa-heart"></i> by turntabl Ghana</p>
              <span>Copyright &copy; || All right reserved</span>
            </div>
            <div className="col-md-2">
              <div><a href="https://github.com/turntabl" className="link" target="_blank">Follow us on <i className="fa fa-github"></i></a></div>
              <div><a href="https://twitter.com/turntablio" className="link" target="_blank">Follow us on <i className="fa fa-twitter"> </i></a></div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Applicant