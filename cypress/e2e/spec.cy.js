describe('Load Posts', () => {
  it('successfully loads', () => {
    cy.visit('http://localhost:5173/')
    cy.contains('Current Path: /')
    cy.get('a[href="/posts"]').click()
    cy.get('input').type('Hello World')
    cy.get('button').contains('Add').click()
    cy.contains('Hello World')
    // cy.get('tr').contains('Hello World').get('button').click()

    // cy.contains("Click Me").click()
  })
})
