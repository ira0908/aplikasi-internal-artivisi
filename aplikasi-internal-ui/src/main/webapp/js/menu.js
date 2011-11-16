// Begin CSS Horizontal Menu - menu ver 3.15 2009
// NOTE: If you use a ' add a slash before it like this \'

var menuside		= "left"	// MENU SIDE | left | right | center
var fixwrap		= "no"		// MAKE yes ONLY IF MENUS ARE WRAPPING
var menuwidth		= "900"		// TOTAL MENU WIDTH TO FIX WRAP

document.write('<table cellpadding="0" cellspacing="0" border="0" class="menutable"><tr><td class="printhide" align="'+menuside+'">');
document.write('<table cellpadding="0" cellspacing="0" border="0"><tr><td>');
document.write('<ul id="menunav">');

// START MENU LINKS - EDIT BELOW THIS AREA
document.write('<li style="width: 90px;"><a href="${base}/app/index.html">Home</a></li>');
document.write('  <li style="width: 90px;"><a href="${base}/app/index.html">System</a>'); 
document.write('    <ul>');
document.write('      <li><a href="${base}/app/system/addoperator">Operator</a></li>');
document.write('      <li><a href="">Role</a></li>');
document.write('      <li><a href="">Hari Libur</a></li>');
document.write('      <li><a href="">Kode Eror</a></li>');
document.write('      <li><a href="">Tarif Prepaid</a></li>');
document.write('      <li><a href="">Tarif Postpaid</a></li>');
document.write('    </ul>');
document.write('  </li>');

document.write('  <li style="width: 95px;"><a href="index.html">Housekeeping</a>'); 
document.write('    <ul>');
document.write('      <li><a href="index.html">Inject Transaksi</a>');
document.write('      <ul>');
document.write('        <li><a href="index.html">Prabayar</a></li>');
document.write('        <li><a href="index.html">Pascabayar</a></li>');
document.write('        <li><a href="index.html">Asuransi</a></li>');
document.write('        <li><a href="index.html">Flash Topup</a></li>');
document.write('        <li><a href="index.html">BFI Finance</a></li>');
document.write('      </ul>');
document.write('      </li>');
document.write('      <li><a href="index.html">Hapus Pending Purchase</a></li>');
document.write('      <li><a href="index.html">Reset Rekap Transaksi</a>');
document.write('      <ul>');
document.write('        <li><a href="index.html">Prabayar</a></li>');
document.write('        <li><a href="index.html">Pascabayar</a></li>');
document.write('        <li><a href="index.html">Asuransi</a></li>');
document.write('        <li><a href="index.html">Flash Topup</a></li>');
document.write('        <li><a href="index.html">BFI Finance</a></li>');
document.write('      </ul>');
document.write('      </li>');
document.write('      <li><a href="index.html">Reset Rekap Saldo</a></li>');
document.write('      <li><a href="index.html">Proses BOD</a></li>');
document.write('    </ul>');
document.write('  </li>');

document.write('  <li style="width: 90px;"><a href="index.html">Finance</a>');
document.write('    <ul>');
document.write('      <li><a href="transferDeposit.htm">Transfer Deposit</a></li>');
document.write('      <li><a href="waralaba.htm">Managemen Waralaba</a></li>');
document.write('      <li><a href="">Entry Setoran</a></li>');
document.write('      <li><a href="">Pembatalan Setoran</a></li>');
document.write('      <li><a href="">Rekap Setoran</a></li>');
document.write('      <li><a href="">Rekap Batal Setoran</a></li>');
document.write('      <li><a href="depositPoin.htm">Entry Deposit Poin</a></li>');
document.write('    </ul>');
document.write('  </li>');

document.write('  <li style="width: 95px;"><a href="index.html">Administrasi</a>');
document.write('    <ul>');
document.write('      <li><a href="">Rekap Saldo Loket</a></li>');
document.write('      <li><a href="">Berita Acara Rekon</a></li>');
document.write('    </ul>');
document.write('  </li>');

document.write('  <li style="width: 90px;"><a href="index.html">Loket</a>');
document.write('    <ul>');
document.write('      <li><a href="">Loket</a></li>');
document.write('      <li><a href="entryToken.htm">Entry Token</a></li>');
document.write('      <li><a href="">Entry No Hp</a></li>');
document.write('      <li><a href="">Group Loket</a></li>');
document.write('      <li><a href="">Status Blokir</a></li>');
document.write('      <li><a href="">Update Blokir</a></li>');
document.write('      <li><a href="">History Blokir</a></li>');
document.write('    </ul>');
document.write('  </li>');

document.write('  <li style="width: 90px;"><a href="index.html">Laporan</a>');
document.write('    <ul>');
document.write('      <li><a href="">Waralaba</a></li>');
document.write('      <li><a href="">Downline</a></li>');
document.write('      <li><a href="">Rekap BFI Finance</a></li>');
document.write('      <li><a href="">Rekap Flash Topup</a></li>');
document.write('      <li><a href="">Rekap Asuransi</a></li>');
document.write('      <li><a href="">Rekap Prabayar</a></li>');
document.write('      <li><a href="">Rekap Pascabayar</a></li>');
document.write('    </ul>');
document.write('  </li>');

document.write('  <li style="width: 90px;"><a href="index.html">Tarif</a>');
document.write('    <ul>');
document.write('      <li><a href="">Tarif Poin</a></li>');
document.write('      <li><a href="">Tarif Downline</a></li>');
document.write('      <li><a href="">Tarif Upline</a></li>');
document.write('    </ul>');
document.write('  </li>');

document.write('  <li style="width: 90px;"><a href="index.html">Biller</a>');
document.write('    <ul>');
document.write('      <li><a href="">Rekon BFI Finance</a></li>');
document.write('      <li><a href="">Rekon Flash Topup</a></li>');
document.write('      <li><a href="">Rekon Asuransi</a></li>');
document.write('      <li><a href="">Rekon Prepaid</a></li>');
document.write('      <li><a href="">Rekon Postpaid</a></li>');
document.write('    </ul>');
document.write('  </li>');

document.write('  <li style="width: 95px;"><a href="index.html">SMS Gateway</a>');
document.write('  </li>');
// END LINKS //

document.write('</ul>');
document.write('</td></tr></table>');
   if (fixwrap == "yes") {
document.write('<img src="picts/spacer.gif" width="'+menuwidth+'" height="1"><br>');
}
document.write('</td></tr></table>');
// END -->
