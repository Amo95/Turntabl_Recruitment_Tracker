import React from "react";
import loginImg from "../../login.svg";
import { connect } from 'react-redux'
import { Modal } from 'antd';
import { css } from "@emotion/core";
import ClockLoader from "react-spinners/ClockLoader";
import { Link } from 'react-router-dom'

import { loginUser } from '../../service/actions/actions'
import { Redirect } from "react-router-dom";
class Login extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      email: "",
      password: "",
      loader: () => <></>
    }
  }

  onChangeHandler = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  }

  onSubmitHandler = (e) => {
    e.preventDefault()
    const { email, password } = this.state
    this.props.dispatch(loginUser(email, password))
  }

  load = () => {
    const override = css`
    display: block;
    margin: 0 auto;
  `;
    return (
      <Modal visible={this.props.loginStart} closable={false} footer={null} centered={true} width="80">
        <ClockLoader
          css={override}
          size={100}
          color={" #00ffff"}
        />
      </Modal>
    )
  }
  render() {
    const { email, password } = this.state
    if (this.props.login_stat || localStorage.getItem("id") != null) {
      return <Redirect to="/apply" />
    } else {
      return (
        <div>
          {this.props.loginStart ? this.load() : this.state.loader()}
          <form onSubmit={this.onSubmitHandler}>
            <div className="base-container" ref={this.props.containerRef}>
              <div className="header">Login</div>
              <div className="content">
                <div className="image">
                  <img src={loginImg} />
                </div>
                <div className="form">
                  <div className="form-group">
                    <label htmlFor="email">Email</label>
                    <input type="email" name="email" placeholder="Enter Email" onChange={this.onChangeHandler} value={email} required />
                  </div>
                  <div className="form-group">
                    <label htmlFor="email">Password</label>
                    <input type="password" name="password" placeholder="Enter Password" onChange={this.onChangeHandler} value={password} required />
                  </div>
                </div>
              </div>
              <div className="footer">
                <button type="submit" className="button">
                  Login
            </button>
              </div>
              <Link to="/recover" target="_blank" rel="noopener noreferrer"> <b>Forgot Password?</b> </Link>
            </div>
          </form>
        </div>
      );
    }
  }
}
const mapStateToProps = state => ({
  loginStart: state.Login.login_init,
  uId: state.Login.id,
  uEmail: state.Login.email,
  login_stat: state.Login.login_status
});

export default connect(mapStateToProps)(Login)
