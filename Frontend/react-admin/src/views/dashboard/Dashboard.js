import React, { lazy, useState, useEffect } from 'react'
import {
  CCard,
  CCardBody,
  CCol,
  CRow,
} from '@coreui/react'
import CIcon from '@coreui/icons-react'

import { getApplicantdata } from '../../service/service';

import MainChartExample from '../charts/MainChartExample.js'
import TablesData from './tables'
import Search from './search'


const WidgetsDropdown = lazy(() => import('../widgets/WidgetsDropdown.js'))
const WidgetsBrand = lazy(() => import('../widgets/WidgetsBrand.js'))

class Dashboard extends React.Component {


  state = {
    ApiData: []
  }

  async componentDidMount() {
    let data = await getApplicantdata();
    this.setState({ ApiData: data })
  }

  render() {


    return (
      <>
        <WidgetsDropdown />
        <CRow>
          <CCol>
            <CCard>

              <CCardBody>
                <CRow>
                  <CCol xs="12" md="6" xl="6">
                  </CCol>
                </CRow>
                <br />

                <div style={{ width: "50%" }}><Search />
                </div>
                <br />
                <TablesData
                  applicantData={this.state.ApiData}
                />
              </CCardBody>
            </CCard>
          </CCol>
        </CRow>
      </>
    )
  }
}

export default Dashboard
