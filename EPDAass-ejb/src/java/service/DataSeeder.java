/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.SuperAdmin;

/**
 *
 * @author vandycklai
 */
@Stateless
public class DataSeeder {

    @PersistenceContext(unitName = "EPDAass-ejbPU")
    private EntityManager em;

    public void seedDatabase(
        int numberOfCustomers,
        int petsPerCustomer,
        int appointmentsPerPet,
        int schedulesPerVet
    ) {
//        String queryString =
//            "SELECT * FROM APP.SUPERADMIN";
//        List<SuperAdmin> results = em
//            .createQuery(queryString, SuperAdmin.class)
//            .getResultList();
//        System.out.println(results.size());
        System.out.println("Triggered");
        // Check if the database is empty before seeding
//        if (isDatabaseEmpty()) {
//            List<Veterinarian> veterinarians = new ArrayList<>();
//            for (int i = 0; i < 30; i++) {
//                ManagingStaff managingStaff =
//                    ManagingStaffFactory.createManagingStaff();
//                em.persist(managingStaff);
//
//                Receptionist receptionist =
//                    ReceptionistFactory.createReceptionist();
//                em.persist(receptionist);
//
//                Veterinarian veterinarian =
//                    VeterinarianFactory.createVeterinarian(); // Assuming this factory exists
//                em.persist(veterinarian);
//                veterinarians.add(veterinarian); // Add to list
//            }
//
//            for (Veterinarian vet : veterinarians) {
//                for (int i = 0; i < schedulesPerVet; i++) {
//                    Schedule schedule = ScheduleFactory.create(vet); // Assuming this factory exists
//                    em.persist(schedule);
//                }
//            }
//
//            // loop 10k times to create 10k schedules
//            for (int i = 0; i < 10000; i++) {
//                Schedule schedule = ScheduleFactory.create(
//                    veterinarians.get(
//                        new Random().nextInt(veterinarians.size())
//                    )
//                );
//                em.persist(schedule);
//            }
//
//            for (int i = 0; i < numberOfCustomers; i++) {
//                Customer customer = CustomerFactory.create();
//                em.persist(customer);
//
//                for (int j = 0; j < petsPerCustomer; j++) {
//                    Pet pet = PetFactory.create();
//                    pet.setCustomer(customer); // Assuming Pet class has a setCustomer method
//                    em.persist(pet);
//
//                    for (int k = 0; k < appointmentsPerPet; k++) {
//                        Veterinarian veterinarian = getRandomVeterinarian(); // Implement this method
//                        Appointment appointment = AppointmentFactory.create(
//                            pet,
//                            veterinarian
//                        );
//                        em.persist(appointment);
//                    }
//                }
//            }
//        }
//    }
//
//    private boolean isDatabaseEmpty() {
//        // Check if any of the relevant tables are empty
//        long customerCount = (long) em
//            .createQuery("SELECT COUNT(c) FROM Customer c")
//            .getSingleResult();
//        long petCount = (long) em
//            .createQuery("SELECT COUNT(p) FROM Pet p")
//            .getSingleResult();
//        long managingStaffCount = (long) em
//            .createQuery("SELECT COUNT(m) FROM ManagingStaff m")
//            .getSingleResult();
//        long receptionistCount = (long) em
//            .createQuery("SELECT COUNT(r) FROM Receptionist r")
//            .getSingleResult();
//        long veterinarianCount = (long) em
//            .createQuery("SELECT COUNT(v) FROM Veterinarian v")
//            .getSingleResult();
//        long appointmentCount = (long) em
//            .createQuery("SELECT COUNT(a) FROM Appointment a")
//            .getSingleResult();
//
//        return (
//            customerCount == 0 &&
//            petCount == 0 &&
//            managingStaffCount == 0 &&
//            receptionistCount == 0 &&
//            veterinarianCount == 0 &&
//            appointmentCount == 0
//        );
//    }
//
//    private Veterinarian getRandomVeterinarian() {
//        List<Veterinarian> veterinarians = em
//            .createQuery("SELECT v FROM Veterinarian v", Veterinarian.class)
//            .getResultList();
//        if (veterinarians.isEmpty()) {
//            return null; // or handle this case as appropriate, e.g., by creating a new Veterinarian
//        }
//        return veterinarians.get(new Random().nextInt(veterinarians.size()));
//    }
    }
}

