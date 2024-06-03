
       identification division.
       program-id. Payroll-03s.

       environment division.
       input-output section.

       file-control.
          select infile assign to "Payroll.masterS.txt" 
              organization is line sequential.

       data division.
       file section.

       fd  infile.
       01  xInRecord.
           05  nDepartment         pic 9.
           05  nEmpNum             pic 9999.
           05  xLastName           pic x(20).
           05  xFirstName          pic x(20).
           05  nPayRate            pic 999v99.


       working-storage section.
       
       77  xEofFlag                pic x       value 'n'.
       77  nLoadSubscript          pic 999     value 0.
       77  nProcessSubscript       pic 999.
       77  nEmpCount               pic 99      value 0.
       77  nGrossPayFoot           pic 9(7)v99 value 0.
       
       01  xEmployeeTable.
           05  xEmployeeElement occurs 100 times.
               10  nDepartmentElement      pic 9.
               10  nEmpNumElement          pic 9999.
               10  xLastNameElement        pic x(20).
               10  xFirstNameElement       pic x(20).
               10  nPayRateElement         pic 999v99.
               10  nGrossPayElement        pic 9(5)v99.
               
       01  xOutputHeading.
          05  filler              pic x(4)    value "Dept".
          05  filler              pic xx      value spaces.
          05  filler              pic x(30)   value "Employee name".
          05  filler              pic xx      value spaces.
          05  filler              pic x(5)    value "Hours".
          05  filler              pic xx      value spaces.
          05  filler              pic x(7)    value "PayRate".
          05  filler              pic xx      value spaces.
          05  filler              pic x(9)    value " GrossPay".

       01  xOutputDetail.
          05  nDepartmentOut      pic 9.
          05  filler              pic xx      value spaces.
          05  xNameOut            pic x(30).
          05  filler              pic xx      value spaces.
          05  filler              pic xxxxx   value '   40'.
          05  filler              pic xx      value spaces.
          05  nePayRateOut        pic zzz9.99.
          05  filler              pic xx      value spaces.
          05  neGrossPayOut       pic zz,zz9.99.
          
       01  xFooter.
          05  neEmpCount          pic z9.
          05  filler              pic x(10)      value ' employees'.
          05  filler              pic x(38)      value spaces.
          05  neGrossPayFoot      pic $$$,$$9.99.
              

       procedure division.
       000-main.
          perform 100-initialization.
          perform 200-report.
          perform 300-termination.
          stop run.


       100-initialization.
          display '  '.
          display ' '.
          open input infile.
          display xOutputHeading.
          
          perform 110-load-table until xEofFlag = 'y'.
          close infile.
          
       110-load-table.
          read infile
            at end
               move 'y' to xEofFlag
            not at end
               add 1 to nLoadSubscript,
               move nDepartment to nDepartmentElement(nLoadSubscript),
               move nEmpNum to nEmpNumElement(nLoadSubscript),
               move xLastName to xLastNameElement(nLoadSubscript),
               move xFirstName to xFirstNameElement(nLoadSubscript),
               move nPayRate to nPayRateElement(nLoadSubscript),
               multiply nPayRate by 40 giving nGrossPayElement(nLoadSubscript),
          end-read.        

    
       200-report.
         
          perform 210-output varying nProcessSubscript from 1 by 1
            until nProcessSubscript > nLoadSubscript.
  
       210-output.
          add 1 to nEmpCount.
          move nDepartmentElement(nProcessSubscript) to nDepartmentOut.
          move xLastNameElement(nProcessSubscript) to xNameOut.
          move nPayRateElement(nProcessSubscript) to nePayRateOut.
          move nGrossPayElement(nProcessSubscript) to neGrossPayOut.
          add nGrossPayElement(nProcessSubscript) to nGrossPayFoot.
          display xOutputDetail.
          

       300-termination.
         move nEmpCount to neEmpCount.
         move nGrossPayFoot to neGrossPayFoot.
         display ' '.
         display xFooter.
         display ' '.
         display ' '.

