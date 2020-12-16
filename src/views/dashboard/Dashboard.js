import React, { lazy } from 'react'
import {
  CCard,
  CCardBody,
  CCol,
  CRow,
} from '@coreui/react'
import CIcon from '@coreui/icons-react'

import MainChartExample from '../charts/MainChartExample.js'
import Tables from './tables'
import Search from './search'


const WidgetsDropdown = lazy(() => import('../widgets/WidgetsDropdown.js'))
const WidgetsBrand = lazy(() => import('../widgets/WidgetsBrand.js'))

const Dashboard = () => {
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

              <div style = {{width:"50%"}}><Search/>
              </div>
              <br/>
              
              <Tables/>
            </CCardBody>
          </CCard>
        </CCol>
      </CRow>
    </>
  )
}

export default Dashboard
