import React, { Component } from 'react';
import { logoutUser } from '../../service/actions/actions'
import { connect } from 'react-redux'
import { Redirect } from 'react-router-dom'

class Header extends Component {
    state = {}

    onSubmitHandler = () => {
        localStorage.clear();
        return <Redirect to="/" />
    }
    render() {
        return (
            <nav className="navbar navbar-expand-lg nav-bar">
                <h2 className="navbar-brand"><img src="/images/logo.jpg" width="100" alt="" /></h2>
                <div className=" ml-auto">
                    <form onSubmit={this.onSubmitHandler} >
                        <button type="submit" className="btn btn-outline-danger text-light" onClick={this.onSubmitHandler}>Logout</button>
                    </form>

                </div>
            </nav>
        );
    }
}

export default connect()(Header);