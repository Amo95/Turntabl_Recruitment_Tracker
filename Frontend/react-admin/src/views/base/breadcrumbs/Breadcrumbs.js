import React from 'react'
import {
  CBreadcrumb,
  CBreadcrumbItem,
  CBreadcrumbRouter,
  CCard,
  CCardBody,
  CCardHeader,
  CLink,
  CCol,
  CRow
} from '@coreui/react'
import { DocsLink } from 'src/reusable'
import routes from '../../../routes'
import RecruitmentTables from './recruitment-tables'
import TabContent from './Tabs'
// import Searchs from './searchs'


const Breadcrumbs = () => {
  return (
    <CRow>
      <CCol xs="12">
        <CCard>

          <CCardBody>

            {/* <div style = {{width:"50%"}}><Searchs/>
              </div>
              <br/> */}
            {/* <h6>CBreadcrumbRouter wrapper component</h6>
            <CBreadcrumbRouter routes={routes}/>
            <h6>Manual</h6>
            <CBreadcrumb>
              <CBreadcrumbItem>
                <CLink>Home</CLink>  */}
            <TabContent />

            {/* </CBreadcrumbItem>
              <CBreadcrumbItem active>Library</CBreadcrumbItem>
            </CBreadcrumb>
            <CBreadcrumb>
              <CBreadcrumbItem>
                <CLink>Home</CLink>
              </CBreadcrumbItem>
              <CBreadcrumbItem>
                <CLink>Library</CLink>]][[]]
              </CBreadcrumbItem>
              <CBreadcrumbItem active>Data</CBreadcrumbItem>
            </CBreadcrumb>
            <CBreadcrumb>
              <CBreadcrumbItem>
                <CLink>Home</CLink>
              </CBreadcrumbItem>
              <CBreadcrumbItem>
                <CLink>Library</CLink>
              </CBreadcrumbItem>
              <CBreadcrumbItem>
                <CLink>Data</CLink>
              </CBreadcrumbItem>
              <CBreadcrumbItem active>
                <span>Bootstrap</span>
              </CBreadcrumbItem>
            </CBreadcrumb>  */}
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>


  )
}

export default Breadcrumbs
