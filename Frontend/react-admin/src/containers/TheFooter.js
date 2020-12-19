import React from 'react'
import { CFooter } from '@coreui/react'

const TheFooter = () => {
  return (
    <CFooter fixed={false}>
      <div>copyright &copy; {new Date().getFullYear()}</div>
    </CFooter>
  )
}

export default React.memo(TheFooter)
