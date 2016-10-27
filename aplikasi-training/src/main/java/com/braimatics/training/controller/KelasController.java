package com.braimatics.training.controller;

import com.braimatics.training.dao.KelasDao;
import com.braimatics.training.dao.MateriDao;
import com.braimatics.training.dao.PesertaDao;
import com.braimatics.training.entity.Kelas;
import com.braimatics.training.entity.Materi;
import com.braimatics.training.entity.Peserta;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes(names = {"daftarMateri", "daftarPeserta"})
@Controller
@RequestMapping("/kelas")
public class KelasController {

    @Autowired
    private KelasDao kd;
    @Autowired
    private MateriDao md;
    @Autowired
    private PesertaDao pd;

    @ModelAttribute("pilihanPeserta")
    public Iterable<Peserta> pilihanPeserta() {
        return pd.findAll();
    }

    @ModelAttribute("pilihanMateri")
    public Iterable<Materi> daftarMateri() {
        return md.findAll();
    }

    @RequestMapping("list")
    public void daftarKelas(Pageable page, ModelMap mm) {
        mm.addAttribute("daftarKelas", kd.findAll(page));
    }

    @RequestMapping("view")
    public void detailKelas() {
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public void tampilkanForm(
            @RequestParam(name = "id", required = false) Kelas kelas,
            @RequestParam(name = "id_materi", required = false) Materi materi,
            @RequestParam(name = "id_peserta", required = false) Peserta peserta,
            @RequestParam(name = "action", required = false) String action,
            @SessionAttribute(name = "daftarMateri", required = false) List<Materi> daftarMateri,
            @SessionAttribute(name = "daftarPeserta", required = false) List<Peserta> daftarPeserta,
            ModelMap mm) {

        if (kelas != null) {
            mm.addAttribute("kelas", kelas);

            if(daftarMateri == null) {
                daftarMateri = kelas.getDaftarMateri();
            }
            
            if(daftarPeserta == null){
                daftarPeserta = kelas.getDaftarPeserta();
            }
        } else {
            mm.addAttribute("kelas", new Kelas());
            if (daftarMateri == null) {
                daftarMateri = new ArrayList<>();
            }

            if (daftarPeserta == null) {
                daftarPeserta = new ArrayList<>();
            }
        }

        if (materi != null) {
            if("add".equalsIgnoreCase(action)) {
                daftarMateri.add(materi);
            } else if("remove".equalsIgnoreCase(action)) {
                daftarMateri.remove(materi);
            } 
        }

        if (peserta != null) {
            if("add".equalsIgnoreCase(action)) {
                daftarPeserta.add(peserta);
            } else if("remove".equalsIgnoreCase(action)) {
                daftarPeserta.remove(peserta);
            } 
        }

        mm.addAttribute("daftarMateri", daftarMateri);
        mm.addAttribute("daftarPeserta", daftarPeserta);
    }

    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String prosesForm(@ModelAttribute @Valid Kelas kelas, 
            BindingResult hasilValidasi, 
            SessionStatus status,
            @SessionAttribute(name = "daftarMateri", required = false) List<Materi> daftarMateri,
            @SessionAttribute(name = "daftarPeserta", required = false) List<Peserta> daftarPeserta
            ) {
        if(hasilValidasi.hasErrors()) {
            return "/kelas/form";
        }
        
        kelas.setDaftarMateri(daftarMateri);
        kelas.setDaftarPeserta(daftarPeserta);
        kd.save(kelas);
        
        return "redirect:list";
    }
}
