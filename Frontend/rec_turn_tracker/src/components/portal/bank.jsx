import React from "react";
import { connect } from 'react-redux';
import ReactWizard from "react-bootstrap-wizard";
import {
  Container,
  Row,
  Col,
  FormGroup,
  Input,
  Label
} from "reactstrap";

import { message } from 'antd';

import { submitApplicantData } from '../../service/actions/actions'

import "../applicant/applyv2.scss";


import "bootstrap/dist/css/bootstrap.css";
import SimpleReactValidator from 'simple-react-validator';




//==========================================First component=================================
// First component
class FirstStep extends React.Component {
    constructor(props) {
  
      super(props);
      this.state = {
        bank_name: "",
        bank_branch: "",
      };
    }
  
    validator = new SimpleReactValidator();
  
    onChangeHandler = (event) => {
      let name = event.target.name;
      let value = event.target.value;
      this.setState({ [name]: value })
    }
  
    // submitForm() {
    //   if (this.validator.allValid()) {
    //     alert('You submitted the form and stuff!');
    //   } else {
    //     this.validator.showMessages();
  
    //     this.forceUpdate();
    //   }
    // }
  
    isValidated() {
      const { bank_name, bank_branch} = this.state;
      console.log(bank_name)
      if (bank_name.length > 0 && bank_branch.length > 0) {
        return true;
      }
      else {
        message.error("All required fields must be completed")
        return false
      }
  
    }
  
    render() {
      const { bank_name, bank_branch } = this.state;
        return <Container className="fallcack">
                    <Row>
            
                    <Col xs={12} md={6} className="mr-auto ml-auto">
                        <FormGroup>
            
                        <Label for="bank_name">Bank Name <span className="text-danger">*</span></Label>
                        <Input type="text" name="bank_name" id="bank_name" placeholder="Enter Bank Name" value={bank_name} onChange={this.onChangeHandler} />
                        </FormGroup>
                    </Col>
                    <Col xs={12} md={6} className="mr-auto ml-auto">
                        <FormGroup>
                        <Label for="bank_branch">Bank Branch Name<span className="text-danger">*</span></Label>
                        <Input type="text" name="bank_branch" id="bank_branch" placeholder="Enter Branch Name" value={bank_branch} onChange={this.onChangeHandler} />
                        </FormGroup>
                    </Col>
            
                    </Row>
                </Container>;
    }
}
  // =====================end of first component==================


  //==========================================Second component=================================
// Second component
class SecondStep extends React.Component {
    constructor(props) {
  
      super(props);
      this.state = {
        account_name: "",
        account_number: "",
        account_type: ""
      };
    }
  
    validator = new SimpleReactValidator();
  
    onChangeHandler = (event) => {
      let name = event.target.name;
      let value = event.target.value;
      this.setState({ [name]: value })
    }
  
    // submitForm() {
    //   if (this.validator.allValid()) {
    //     alert('You submitted the form and stuff!');
    //   } else {
    //     this.validator.showMessages();
  
    //     this.forceUpdate();
    //   }
    // }
  
    isValidated() {
      const { account_name, account_number, account_type} = this.state;
      console.log(account_name)
      if (account_name.length > 0 && account_number.length > 0 && account_type.length > 0) {
        return true;
      }
      else {
        message.error("Complete all required fields relateed to Account")
        return false
      }
  
    }
  
    render() {
      const { account_name, account_number, account_type} = this.state;
        return <Container className="fallcack">
                    <Row>
                        <Col xs={12} md={6} className="mr-auto ml-auto">
                            <FormGroup>
                            <Label for="account_name">Name on Account <span className="text-danger">*</span></Label>
                            <Input type="text" name="account_name" id="account_name" placeholder="Enter Name on Account" value={account_name} onChange={this.onChangeHandler} />
                            </FormGroup>
                        </Col>
                        <Col xs={12} md={6} className="mr-auto ml-auto">
                            <FormGroup>
                            <Label for="account_number">Account Number<span className="text-danger">*</span></Label>
                            <Input type="text" name="account_number" id="account_number" placeholder="Enter Account Number" value={account_number} onChange={this.onChangeHandler} />
                            </FormGroup>
                        </Col>
                        <Col xs={12} md={6} className="mr-auto ml-auto">
                            <FormGroup>
                            <Label for="account_type">Account Type<span className="text-danger">*</span></Label>
                            <Input type="text" name="account_type" id="account_type" placeholder="Enter Account Type<" value={account_type} onChange={this.onChangeHandler} />
                            </FormGroup>
                        </Col>
                    </Row>
                </Container>;
    }
}
  // =====================end of Second component==================

  var steps = [
    // this step hasn't got a isValidated() function, so it will be considered to be true
  
    {
      stepName: "Bank Info",
      component: FirstStep
    },
    // this step will be validated to false
    {
      stepName: "Account Info",
      component: SecondStep
    },
  ];



class Bank extends React.Component {
    state = {  }

    finishButtonClick(allStates) {
        const { Bank_Info, Account_info } = allStates;
    
        const {bank_name, bank_branch } = Bank_Info;
        const { account_name, account_number, account_type } = Account_info;
    
        console.log(localStorage.getItem("id"));
    
        submitApplicantData(
          localStorage.getItem("id"),
          bank_name,
          bank_branch,
          account_name,
          account_number,
          account_type
        );
        console.log(bank_name);
        console.log(allStates);
    
      }

    render() { 
        return ( 
        <div className="bank-body">
            <a id ="myform">
                <div id="form" className="fallback">
                <div className="contain">
                        <ReactWizard
                            steps={steps}
                            title="YOUR BANK DETAILS"
                            headerTextCenter
                            validate
                            finishButtonClick={this.finishButtonClick}
                        />
                    </div>
                </div>
            </a>
        </div> );
    }
}
 
export default connect() (Bank);